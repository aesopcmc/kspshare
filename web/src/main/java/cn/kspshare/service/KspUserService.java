package cn.kspshare.service;

import cn.kspshare.domain.KspUser;

public interface KspUserService {
    KspUser findByUserName(String username);

    boolean doRegister(KspUser kspUser);
}
