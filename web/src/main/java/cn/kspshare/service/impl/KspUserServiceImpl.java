package cn.kspshare.service.impl;

import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.constant.BaseConstant;
import cn.kspshare.domain.KspUser;
import cn.kspshare.dto.request.KspUserDto;
import cn.kspshare.mapper.KspUserDynamicSqlSupport;
import cn.kspshare.mapper.KspUserMapper;
import cn.kspshare.service.KspUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
public class KspUserServiceImpl implements KspUserService {
    @Autowired
    private KspUserMapper userMapper;
    @Autowired
    private BaseConstant baseConstant;

    @Override
    public KspUser findByUserName(String username) {
        List<KspUser> list = userMapper.selectByExample().where(KspUserDynamicSqlSupport.username, isEqualTo(username)).build().execute();
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    public KspUser findByEmail(String email) {
        List<KspUser> list = userMapper.selectByExample().where(KspUserDynamicSqlSupport.email, isEqualTo(email)).build().execute();
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    public KspUser findByUserNameOrEmail(String nameOrEmail) {
        List<KspUser> list = userMapper.selectByExample()
                .where(KspUserDynamicSqlSupport.username, isEqualTo(nameOrEmail))
                .or(KspUserDynamicSqlSupport.email, isEqualTo(nameOrEmail))
                .build()
                .execute();
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    @Transactional
    public boolean doRegister(KspUserDto dto) {
        KspUser kspUser = new KspUser();
        kspUser.setUsername(dto.getUsername());
        kspUser.setOid(IDGenerator.id());
        //使用spring security密码加密
        String password = new BCryptPasswordEncoder().encode(dto.getPassword());
        kspUser.setPassword(password);
        kspUser.setNickname(dto.getUsername());
        kspUser.setEmail(dto.getEmail());
        kspUser.setRoles(baseConstant.ROLE_USER);
        int i = userMapper.insertSelective(kspUser);
        return i>=1;
    }

}
