package cn.kspshare.backstage.service.impl;

import cn.kspshare.backstage.service.KspAdminUserService;
import cn.kspshare.domain.KspAdminUser;
import cn.kspshare.domain.KspUser;
import cn.kspshare.mapper.KspAdminUserDynamicSqlSupport;
import cn.kspshare.mapper.KspAdminUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
public class KspAdminUserServiceImpl implements KspAdminUserService {

    @Autowired
    private KspAdminUserMapper adminUserMapper;

    @Override
    public KspAdminUser findByUsername(String username) {
        List<KspAdminUser> list = adminUserMapper.selectByExample().where(KspAdminUserDynamicSqlSupport.username, isEqualTo(username)).build().execute();
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }
}
