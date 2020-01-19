package cn.kspshare.service.impl;

import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.dto.PermDto;
import cn.kspshare.mapper.*;
import cn.kspshare.service.KspPermService;
import cn.kspshare.service.KspRoleService;
import cn.kspshare.domain.KspPerm;
import cn.kspshare.domain.KspRole;
import cn.kspshare.domain.KspRolePermRe;
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
public class KspPermServiceImpl implements KspPermService {
    @Autowired
    private KspRolePermReMapper rolePermReMapper;
    @Autowired
    private KspPermMapper permMapper;
    @Autowired
    private KspRoleService roleService;
    @Autowired
    private KspPermService permService;

    @Override
    public List<KspPerm> listByRole(Long roleId) {
        List<KspRolePermRe> rolePermReList = rolePermReMapper.select( c ->
                c.where(KspRolePermReDynamicSqlSupport.roleId, isEqualTo(roleId)));

        List<Long> permIds = rolePermReList.stream().map(KspRolePermRe::getPermId).collect(Collectors.toList());
        List<KspPerm> permList = permMapper.select(c ->
                c.where(KspPermDynamicSqlSupport.oid, isIn(permIds)));
        return permList;
    }

    @Override
    public List<String> listByUser(Long userId) {
        List<String> perm = new ArrayList<>();
        //查找角色
        List<KspRole> roleList = roleService.listByAdminUserId(userId);
        //TODO 此处查询可能会有重复的权限
        for (KspRole kspRole : roleList) {
            //查找权限
            List<KspPerm> permList = permService.listByRole(kspRole.getOid());
            for (KspPerm kspPerm : permList) {
                perm.add(kspPerm.getCode());
            }
        }
        return perm;
    }

    @Override
    @Transactional(rollbackFor = Exception.class )
    public ResultBean add(PermDto dto) {
        KspPerm exist = this.findByPermCode(dto.getCode());
        if(exist!=null) {
            return ResultBean.FAIL("权限编码已存在！");
        }

        KspPerm domain = new KspPerm();
        BeanUtils.copyProperties(dto, domain);
        domain.setOid(IDGenerator.id());
        permMapper.insertSelective(domain);
        return ResultBean.SUCCESS();
    }

    @Override
    @Transactional(rollbackFor = Exception.class )
    public ResultBean update(PermDto dto, Long oid) {
        KspPerm exist = this.findByPermCode(dto.getCode());
        if(exist!=null && !exist.getOid().equals(oid)) {
            return ResultBean.FAIL("用户名已存在！");
        }

        KspPerm updateRecord = new KspPerm();
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
        List<KspPerm> list = permMapper.select(c -> c.where(KspPermDynamicSqlSupport.resourceId, isEqualTo(resourceId)));
        return ResultBean.SUCCESS(list);
    }

    /**
     * 根据权限编码编码查找权限
     * @param code 权限编码
     * @return
     */
    private KspPerm findByPermCode(String code) {
        List<KspPerm> list = permMapper.select(c -> c.where(KspPermDynamicSqlSupport.code, isEqualTo(code)));
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }
}
