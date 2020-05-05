package cn.kspshare.service.impl;

import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.dto.PermDto;
import cn.kspshare.mapper.*;
import cn.kspshare.service.PermService;
import cn.kspshare.service.RoleService;
import cn.kspshare.domain.Perm;
import cn.kspshare.domain.Role;
import cn.kspshare.domain.RolePermRe;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class PermServiceImpl implements PermService {
    @Autowired
    private RolePermReMapper rolePermReMapper;
    @Autowired
    private PermMapper permMapper;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermService permService;

    @Override
    public List<Perm> listByRole(Long roleId) {
        List<RolePermRe> rolePermReList = rolePermReMapper.select( c ->
                c.where(RolePermReDynamicSqlSupport.roleId, isEqualTo(roleId)));

        List<Long> permIds = rolePermReList.stream().map(RolePermRe::getPermId).collect(Collectors.toList());
        List<Perm> permList = permMapper.select(c ->
                c.where(PermDynamicSqlSupport.oid, isIn(permIds)));
        return permList;
    }

    @Override
    public List<String> listByUser(Long userId) {
        List<String> perm = new ArrayList<>();
        //查找角色
        List<Role> roleList = roleService.listByAdminUserId(userId);
        //TODO 此处查询可能会有重复的权限
        for (Role kspRole : roleList) {
            //查找权限
            List<Perm> permList = permService.listByRole(kspRole.getOid());
            for (Perm kspPerm : permList) {
                perm.add(kspPerm.getCode());
            }
        }
        return perm;
    }

    @Override
    @Transactional(rollbackFor = Exception.class )
    public ResultBean add(PermDto dto) {
        Perm exist = this.findByPermCode(dto.getCode());
        if(exist!=null) {
            return ResultBean.FAIL("权限编码已存在！");
        }
        Perm domain = new Perm();
        BeanUtils.copyProperties(dto, domain);
        domain.setOid(IDGenerator.id());
        permMapper.insertSelective(domain);
        return ResultBean.SUCCESS();
    }

    @Override
    @Transactional(rollbackFor = Exception.class )
    public ResultBean update(PermDto dto, Long oid) {
        Perm exist = this.findByPermCode(dto.getCode());
        if(exist!=null && !exist.getOid().equals(oid)) {
            return ResultBean.FAIL("用户名已存在！");
        }

        Perm updateRecord = new Perm();
        BeanUtils.copyProperties(dto, updateRecord);
        updateRecord.setOid(oid);
        updateRecord.setUpdateTime(LocalDateTime.now());
        permMapper.updateByPrimaryKeySelective(updateRecord);
        return ResultBean.SUCCESS();
    }

    @Override
    @Transactional(rollbackFor = Exception.class )
    public ResultBean delete(Long oid) {
        permMapper.deleteByPrimaryKey(oid);
        //TODO 删除用户权限关系 、 删除角色权限关系
        return ResultBean.SUCCESS();
    }

    @Override
    public ResultBean listByResource(Long resourceId) {
        List<Perm> list = permMapper.select(c -> c.where(PermDynamicSqlSupport.resourceId, isEqualTo(resourceId)));
        return ResultBean.SUCCESS(list);
    }

    /**
     * 根据权限编码编码查找权限
     * @param code 权限编码
     * @return
     */
    private Perm findByPermCode(String code) {
        List<Perm> list = permMapper.select(c -> c.where(PermDynamicSqlSupport.code, isEqualTo(code)));
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }
}
