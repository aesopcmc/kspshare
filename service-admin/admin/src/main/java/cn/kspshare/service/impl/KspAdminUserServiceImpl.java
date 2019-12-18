package cn.kspshare.service.impl;

import cn.kspshare.dto.KspAdminUserListConditionDto;
import cn.kspshare.restful.ResultBean;
import cn.kspshare.service.KspAdminUserService;
import cn.kspshare.domain.KspAdminUser;
import cn.kspshare.mapper.KspAdminUserDynamicSqlSupport;
import cn.kspshare.mapper.KspAdminUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isLike;

@Service
public class KspAdminUserServiceImpl implements KspAdminUserService {
    @Autowired
    private KspAdminUserMapper adminUserMapper;

    @Override
    public ResultBean listCondition(KspAdminUserListConditionDto dto) {

        List<KspAdminUser> list = adminUserMapper.selectByExample()
                .where(KspAdminUserDynamicSqlSupport.username, isLike(dto.getUserNameOrRealNameOrEmail()))
                .or(KspAdminUserDynamicSqlSupport.realname, isLike(dto.getUserNameOrRealNameOrEmail()))
                .or(KspAdminUserDynamicSqlSupport.email, isLike(dto.getUserNameOrRealNameOrEmail()))
                .build()
                .execute();

        return ResultBean.SUCCESS(list);
    }

    @Override
    public KspAdminUser findByUsername(String username) {
        List<KspAdminUser> list = adminUserMapper.selectByExample().where(KspAdminUserDynamicSqlSupport.username, isEqualTo(username)).build().execute();
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }
}
