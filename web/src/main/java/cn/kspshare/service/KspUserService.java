package cn.kspshare.service;

import cn.kspshare.domain.KspUser;
import cn.kspshare.dto.request.KspUserDto;

public interface KspUserService {
    KspUser findByUserName(String username);

    KspUser findByEmail(String email);

    KspUser findByUserNameOrEmail(String nameOrEmail);

    boolean doRegister(KspUserDto kspUser);

}
