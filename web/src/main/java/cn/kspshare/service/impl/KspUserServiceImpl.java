package cn.kspshare.service.impl;

import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.constant.KspConstants;
import cn.kspshare.domain.KspUser;
import cn.kspshare.domain.KspVerificationToken;
import cn.kspshare.dto.request.KspUserDto;
import cn.kspshare.mapper.KspUserDynamicSqlSupport;
import cn.kspshare.mapper.KspUserMapper;
import cn.kspshare.mapper.KspVerificationTokenDynamicSqlSupport;
import cn.kspshare.mapper.KspVerificationTokenMapper;
import cn.kspshare.service.KspUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
public class KspUserServiceImpl implements KspUserService {
    @Autowired
    private KspConstants kspConstants;
    @Autowired
    private KspUserMapper userMapper;
    @Autowired
    private KspVerificationTokenMapper verifiMapper;

    @Override
    public KspUser getUser(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

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
    public KspUser doRegister(KspUserDto dto) {
        KspUser kspUser = new KspUser();
        kspUser.setOid(IDGenerator.id());
        kspUser.setUsername(dto.getUsername());
        String password = new BCryptPasswordEncoder().encode(dto.getPassword());//使用spring security密码加密
        kspUser.setPassword(password);
        kspUser.setNickname(dto.getUsername());
        kspUser.setEmail(dto.getEmail());
        kspUser.setRoles(kspConstants.ROLE_USER);
        int i = userMapper.insertSelective(kspUser);
        return i>=1 ? kspUser : null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateUser(KspUser user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createVerificationToken(KspUser user, String token) {
        KspVerificationToken verToken = new KspVerificationToken();
        verToken.setOid(IDGenerator.id());
        verToken.setToken(token);
        verToken.setUserId(user.getOid());
        verToken.setExpiryDate(LocalDateTime.now().plusHours(24));
        verifiMapper.insertSelective(verToken);
    }

    @Override
    public KspVerificationToken findVerificationToken(String token) {
        List<KspVerificationToken> list = verifiMapper.selectByExample().where(KspVerificationTokenDynamicSqlSupport.token, isEqualTo(token)).build().execute();
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

}
