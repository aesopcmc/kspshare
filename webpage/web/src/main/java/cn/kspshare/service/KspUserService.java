package cn.kspshare.service;

import cn.kspshare.domain.Member;
import cn.kspshare.domain.VerificationToken;
import cn.kspshare.dto.request.KspUserDto;

public interface KspUserService {
    Member getUser(Long userId);

    Member findByUserName(String username);

    Member findByEmail(String email);

    Member findByUserNameOrEmail(String nameOrEmail);

    Member doRegister(KspUserDto kspUser);

    int updateUser(Member user);

    /**
     * 创建邮件校验token
     * @param user
     * @param token
     */
    void createVerificationToken(Member user, String token);

    /**
     * 获取验证实体
     * @param token
     * @return
     */
    VerificationToken findVerificationToken(String token);

}
