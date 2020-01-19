package cn.kspshare.service.impl;

import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.config.KspException;
import cn.kspshare.dto.KspRoleDto;
import cn.kspshare.mapper.*;
import cn.kspshare.service.KspRoleService;
import cn.kspshare.domain.KspRole;
import cn.kspshare.domain.KspUserRoleRe;
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
public class KspRoleServiceImpl implements KspRoleService {

    @Autowired
    private KspRoleMapper kspRoleMapper;

    @Autowired
    private KspUserRoleReMapper userRoleReMapper;

    @Override
    @Transactional(rollbackFor = Exception.class )
    public ResultBean add(KspRoleDto dto) {
        //验证角色编码唯一性
        KspRole exist = this.findByCode(dto.getCode());
        if(exist!=null) {
            return ResultBean.FAIL("该角色编码已被使用！");
        }

        //获取父编码link
        Long parentId = dto.getParentId();
        Optional<KspRole> kspRole = kspRoleMapper.selectByPrimaryKey(parentId);
        AtomicReference<String> codeLink = new AtomicReference<>(null);
        kspRole.ifPresent(k-> codeLink.set(codeLink.get()+"-"+k.getCodeLink()));

        KspRole domain = new KspRole();
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
        KspRole exist = this.findByCode(dto.getCode());
        if(exist!=null && !exist.getCode().equals(dto.getCode())) {
            return ResultBean.FAIL("该角色编码已被使用！");
        }

        KspRole updateRecord = new KspRole();
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
        KspRole kspRole = kspRoleMapper.selectByPrimaryKey(oid).get();
        kspRoleMapper.delete(c->c.where(KspRoleDynamicSqlSupport.codeLink, SqlBuilder.isLike(kspRole.getCode())));

        //删除自身
        kspRoleMapper.deleteByPrimaryKey(oid);
        return ResultBean.SUCCESS();
    }

    @Override
    public KspRole findByCode(String code) {
        Optional<KspRole> kspRole = kspRoleMapper.selectOne(c ->
                c.where(KspRoleDynamicSqlSupport.code, SqlBuilder.isEqualTo(code)));
        return kspRole.get();
    }

    @Override
    public List<KspRole> listByAdminUserId(Long userId) {
        List<KspUserRoleRe> userRoleReList = userRoleReMapper.select(c->
                c.where(KspUserRoleReDynamicSqlSupport.userId, isEqualTo(userId)));

        if(CollectionUtils.isEmpty(userRoleReList)) {
            return new ArrayList<>();
        }
        List<Long> roleIds = userRoleReList.stream().map(KspUserRoleRe::getRoleId).collect(Collectors.toList());
        List<KspRole> roleList = kspRoleMapper.select(c ->
                c.where(KspRoleDynamicSqlSupport.oid, isIn(roleIds)));

        return roleList;
    }

    // private void findByCode(Long oid, String code) {
    //     KspRole exist = this.findByCode(code);
    //     if(exist!=null && !exist.getOid().equals(oid)) {
    //         throw new KspException("该资源编码已被使用!");
    //     }
    // }
}
