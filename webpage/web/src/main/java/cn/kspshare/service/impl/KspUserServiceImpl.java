package cn.kspshare.service.impl;

import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.constant.KspConstants;
import cn.kspshare.domain.KspMember;
import cn.kspshare.domain.KspVerificationToken;
import cn.kspshare.dto.request.KspUserDto;
import cn.kspshare.mapper.KspMemberDynamicSqlSupport;
import cn.kspshare.mapper.KspMemberMapper;
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
    private KspMemberMapper userMapper;
    @Autowired
    private KspVerificationTokenMapper verifiMapper;

    @Override
    public KspMember getUser(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public KspMember findByUserName(String username) {
        List<KspMember> list = userMapper.selectByExample().where(KspMemberDynamicSqlSupport.username, isEqualTo(username)).build().execute();
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    public KspMember findByEmail(String email) {
        List<KspMember> list = userMapper.selectByExample().where(KspMemberDynamicSqlSupport.email, isEqualTo(email)).build().execute();
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    public KspMember findByUserNameOrEmail(String nameOrEmail) {
        List<KspMember> list = userMapper.selectByExample()
                .where(KspMemberDynamicSqlSupport.username, isEqualTo(nameOrEmail))
                .or(KspMemberDynamicSqlSupport.email, isEqualTo(nameOrEmail))
                .build()
                .execute();
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    @Transactional
    public KspMember doRegister(KspUserDto dto) {
        KspMember kspUser = new KspMember();
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
    public int updateUser(KspMember user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createVerificationToken(KspMember user, String token) {
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
