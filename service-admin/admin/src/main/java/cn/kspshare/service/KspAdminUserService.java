package cn.kspshare.service;

import cn.kspshare.domain.KspAdminUser;
import cn.kspshare.dto.KspAdminUserDto;
import cn.kspshare.dto.KspAdminUserListConditionDto;
import cn.kspshare.restful.ResultBean;

public interface KspAdminUserService {

    KspAdminUser findByUsername(String username);
    /*
    1.	用户列表
    2.	添加用户
    3.	删除用户
    4.	禁用/启用
    5.	查看编辑
     */
    ResultBean listCondition(KspAdminUserListConditionDto dto);
    ResultBean add(KspAdminUserDto dto);
}
