package cn.kspshare.service;

import cn.kspshare.domain.KspMember;
import cn.kspshare.domain.KspVerificationToken;
import cn.kspshare.dto.request.KspUserDto;

public interface KspUserService {
    KspMember getUser(Long userId);

    KspMember findByUserName(String username);

    KspMember findByEmail(String email);

    KspMember findByUserNameOrEmail(String nameOrEmail);

    KspMember doRegister(KspUserDto kspUser);

    int updateUser(KspMember user);

    /**
     * 创建邮件校验token
     * @param user
     * @param token
     */
    void createVerificationToken(KspMember user, String token);

    /**
     * 获取验证实体
     * @param token
     * @return
     */
    KspVerificationToken findVerificationToken(String token);

}
