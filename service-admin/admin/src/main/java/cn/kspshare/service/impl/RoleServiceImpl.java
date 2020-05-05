package cn.kspshare.service.impl;

import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.dto.KspRoleDto;
import cn.kspshare.mapper.*;
import cn.kspshare.service.RoleService;
import cn.kspshare.domain.Role;
import cn.kspshare.domain.UserRoleRe;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper kspRoleMapper;

    @Autowired
    private UserRoleReMapper userRoleReMapper;

    @Override
    @Transactional(rollbackFor = Exception.class )
    public ResultBean add(KspRoleDto dto) {
        //验证角色编码唯一性
        Role exist = this.findByCode(dto.getCode());
        if(exist!=null) {
            return ResultBean.FAIL("该角色编码已被使用！");
        }

        //获取父编码link
        Long parentId = dto.getParentId();
        Optional<Role> kspRole = kspRoleMapper.selectByPrimaryKey(parentId);
        AtomicReference<String> codeLink = new AtomicReference<>(null);
        kspRole.ifPresent(k-> codeLink.set(codeLink.get()+"-"+k.getCodeLink()));

        Role domain = new Role();
        BeanUtils.copyProperties(dto, domain);
        domain.setOid(IDGenerator.id());
        domain.setCodeLink(codeLink.get());
        kspRoleMapper.insertSelective(domain);

        return ResultBean.SUCCESS();
    }

    @Override
    @Transactional(rollbackFor = Exception.class )
    public ResultBean update(KspRoleDto dto, Long oid) {
        //验证角色编码唯一性
        Role exist = this.findByCode(dto.getCode());
        if(exist!=null && !exist.getCode().equals(dto.getCode())) {
            return ResultBean.FAIL("该角色编码已被使用！");
        }

        Role updateRecord = new Role();
        BeanUtils.copyProperties(dto, updateRecord);
        updateRecord.setOid(oid);
        updateRecord.setUpdateTime(LocalDateTime.now());
        kspRoleMapper.updateByPrimaryKeySelective(updateRecord);
        return ResultBean.SUCCESS();
    }

    @Override
    @Transactional(rollbackFor = Exception.class )
    public ResultBean delete(Long oid) {
        //删除子级
        Role kspRole = kspRoleMapper.selectByPrimaryKey(oid).get();
        kspRoleMapper.delete(c->c.where(RoleDynamicSqlSupport.codeLink, SqlBuilder.isLike(kspRole.getCode())));

        //删除自身
        kspRoleMapper.deleteByPrimaryKey(oid);
        return ResultBean.SUCCESS();
    }

    @Override
    public Role findByCode(String code) {
        Optional<Role> kspRole = kspRoleMapper.selectOne(c ->
                c.where(RoleDynamicSqlSupport.code, SqlBuilder.isEqualTo(code)));
        return kspRole.get();
    }

    @Override
    public List<Role> listByAdminUserId(Long userId) {
        List<UserRoleRe> userRoleReList = userRoleReMapper.select(c->
                c.where(UserRoleReDynamicSqlSupport.userId, isEqualTo(userId)));

        if(CollectionUtils.isEmpty(userRoleReList)) {
            return new ArrayList<>();
        }
        List<Long> roleIds = userRoleReList.stream().map(UserRoleRe::getRoleId).collect(Collectors.toList());
        List<Role> roleList = kspRoleMapper.select(c ->
                c.where(RoleDynamicSqlSupport.oid, isIn(roleIds)));

        return roleList;
    }

    // private void findByCode(Long oid, String code) {
    //     Role exist = this.findByCode(code);
    //     if(exist!=null && !exist.getOid().equals(oid)) {
    //         throw new KspException("该资源编码已被使用!");
    //     }
    // }
}
