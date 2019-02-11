package cn.kspshare.service;

import cn.kspshare.domain.KspUser;
import cn.kspshare.domain.KspVerificationToken;
import cn.kspshare.dto.request.KspUserDto;

public interface KspUserService {
    KspUser getUser(Long userId);

    KspUser findByUserName(String username);

    KspUser findByEmail(String email);

    KspUser findByUserNameOrEmail(String nameOrEmail);

    KspUser doRegister(KspUserDto kspUser);

    int updateUser(KspUser user);

    /**
     * 创建邮件校验token
     * @param user
     * @param token
     */
    void createVerificationToken(KspUser user, String token);

    /**
     * 获取验证实体
     * @param token
     * @return
     */
    KspVerificationToken findVerificationToken(String token);

}
