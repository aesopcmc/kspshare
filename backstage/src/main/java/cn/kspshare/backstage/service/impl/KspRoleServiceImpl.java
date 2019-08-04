package cn.kspshare.backstage.service.impl;

import cn.kspshare.backstage.service.KspRoleService;
import cn.kspshare.domain.KspRole;
import cn.kspshare.domain.KspUserRoleRe;
import cn.kspshare.mapper.KspRoleDynamicSqlSupport;
import cn.kspshare.mapper.KspRoleMapper;
import cn.kspshare.mapper.KspUserRoleReDynamicSqlSupport;
import cn.kspshare.mapper.KspUserRoleReMapper;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KspRoleServiceImpl implements KspRoleService {

    @Autowired
    private KspRoleMapper kspRoleMapper;

    @Autowired
    private KspUserRoleReMapper userRoleReMapper;

    @Override
    public List<KspRole> listByAdminUserId(Long userId) {
        List<KspUserRoleRe> userRoleReList = userRoleReMapper.selectByExample()
                .where(KspUserRoleReDynamicSqlSupport.userId, SqlBuilder.isEqualTo(userId))
                .build()
                .execute();

        List<Long> roleIds = userRoleReList.stream().map(KspUserRoleRe::getRoleId).collect(Collectors.toList());
        List<KspRole> roleList = kspRoleMapper.selectByExample().where(KspRoleDynamicSqlSupport.oid, SqlBuilder.isIn(roleIds))
                .build()
                .execute();

        return roleList;
    }
}