package cn.kspshare.service;

import cn.kspshare.domain.KspAdminUser;

public interface KspAdminUserService {
    KspAdminUser findByUsername(String username);


}
