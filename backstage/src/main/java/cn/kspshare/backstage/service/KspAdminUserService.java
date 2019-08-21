package cn.kspshare.backstage.service;

import cn.kspshare.domain.KspAdminUser;

public interface KspAdminUserService {
    KspAdminUser findByUsername(String username);


}
