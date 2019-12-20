package cn.kspshare.service.impl;

import cn.kspshare.service.KspRoleService;
import cn.kspshare.domain.KspRole;
import cn.kspshare.domain.KspUserRoleRe;
import cn.kspshare.mapper.KspRoleDynamicSqlSupport;
import cn.kspshare.mapper.KspRoleMapper;
import cn.kspshare.mapper.KspUserRoleReDynamicSqlSupport;
import cn.kspshare.mapper.KspUserRoleReMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class KspRoleServiceImpl implements KspRoleService {

    @Autowired
    private KspRoleMapper kspRoleMapper;

    @Autowired
    private KspUserRoleReMapper userRoleReMapper;

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
}
