package cn.kspshare.service.impl;

import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.constant.KspConstants;
import cn.kspshare.domain.Member;
import cn.kspshare.domain.VerificationToken;
import cn.kspshare.dto.request.KspUserDto;
import cn.kspshare.mapper.MemberDynamicSqlSupport;
import cn.kspshare.mapper.MemberMapper;
import cn.kspshare.mapper.VerificationTokenDynamicSqlSupport;
import cn.kspshare.mapper.VerificationTokenMapper;
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
    private MemberMapper userMapper;
    @Autowired
    private VerificationTokenMapper verifiMapper;

    @Override
    public Member getUser(Long userId) {
        return userMapper.selectByPrimaryKey(userId).get();
    }

    @Override
    public Member findByUserName(String username) {
        List<Member> list = userMapper.select(c-> c.where(MemberDynamicSqlSupport.username, isEqualTo(username)));
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    public Member findByEmail(String email) {
        List<Member> list = userMapper.select(c-> c.where(MemberDynamicSqlSupport.email, isEqualTo(email)));
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    public Member findByUserNameOrEmail(String nameOrEmail) {
        List<Member> list = userMapper.select(c-> c.where(MemberDynamicSqlSupport.username, isEqualTo(nameOrEmail))
                .or(MemberDynamicSqlSupport.email, isEqualTo(nameOrEmail)));
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    @Transactional
    public Member doRegister(KspUserDto dto) {
        Member kspUser = new Member();
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
    public int updateUser(Member user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createVerificationToken(Member user, String token) {
        VerificationToken verToken = new VerificationToken();
        verToken.setOid(IDGenerator.id());
        verToken.setToken(token);
        verToken.setUserId(user.getOid());
        verToken.setExpiryDate(LocalDateTime.now().plusHours(24));
        verifiMapper.insertSelective(verToken);
    }

    @Override
    public VerificationToken findVerificationToken(String token) {
        List<VerificationToken> list = verifiMapper.select(c-> c.where(VerificationTokenDynamicSqlSupport.token, isEqualTo(token)));
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

}
