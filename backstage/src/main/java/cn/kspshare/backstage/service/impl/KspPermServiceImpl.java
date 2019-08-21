package cn.kspshare.backstage.service.impl;

import cn.kspshare.backstage.service.KspPermService;
import cn.kspshare.backstage.service.KspRoleService;
import cn.kspshare.domain.KspPerm;
import cn.kspshare.domain.KspRole;
import cn.kspshare.domain.KspRolePermRe;
import cn.kspshare.mapper.KspPermDynamicSqlSupport;
import cn.kspshare.mapper.KspPermMapper;
import cn.kspshare.mapper.KspRolePermReDynamicSqlSupport;
import cn.kspshare.mapper.KspRolePermReMapper;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<KspPerm> listByRoleId(Long roleId) {
        List<KspRolePermRe> rolePermReList = rolePermReMapper.selectByExample()
                .where(KspRolePermReDynamicSqlSupport.roleId, SqlBuilder.isEqualTo(roleId))
                .build()
                .execute();

        List<Long> permIds = rolePermReList.stream().map(KspRolePermRe::getPermId).collect(Collectors.toList());
        List<KspPerm> permList = permMapper.selectByExample()
                .where(KspPermDynamicSqlSupport.oid, SqlBuilder.isIn(permIds))
                .build()
                .execute();

        return permList;
    }

    @Override
    public List<String> listResourceIdByUser(Long userId) {
        List<String> perm = new ArrayList<>();
        //查找角色
        List<KspRole> roleList = roleService.listByAdminUserId(userId);
        //TODO 此处查询可能会有重复的权限
        for (KspRole kspRole : roleList) {
            //查找权限
            List<KspPerm> permList = permService.listByRoleId(kspRole.getOid());
            for (KspPerm kspPerm : permList) {
                perm.add(kspPerm.getPermValue());
            }
        }
        return perm;
    }
}
