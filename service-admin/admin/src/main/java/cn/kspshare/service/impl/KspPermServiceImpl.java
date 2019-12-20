package cn.kspshare.service.impl;

import cn.kspshare.service.KspPermService;
import cn.kspshare.service.KspRoleService;
import cn.kspshare.domain.KspPerm;
import cn.kspshare.domain.KspRole;
import cn.kspshare.domain.KspRolePermRe;
import cn.kspshare.mapper.KspPermDynamicSqlSupport;
import cn.kspshare.mapper.KspPermMapper;
import cn.kspshare.mapper.KspRolePermReDynamicSqlSupport;
import cn.kspshare.mapper.KspRolePermReMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
