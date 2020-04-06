package cn.kspshare.service;

import cn.kspshare.domain.KspAdminUser;
import cn.kspshare.dto.KspAdminUserDto;
import cn.kspshare.dto.KspAdminUserListConditionDto;
import cn.kspshare.common.restful.ResultBean;

public interface AdminUserService {
    /**
     * 添加
     * @param dto
     * @return
     */
    ResultBean add(KspAdminUserDto dto);

    /**
     * 更新
     * @param dto
     * @return
     */
    ResultBean update(KspAdminUserDto dto);

    /**
     * 删除
     * @param oid
     * @return
     */
    ResultBean delete(Long oid);

    /**
     * 组合条件查询
     * @param dto
     * @return
     */
    ResultBean listCondition(KspAdminUserListConditionDto dto);

    /**
     * 用户名查找
     * @param username
     * @return
     */
    KspAdminUser findByUsername(String username);

    /**
     * 启用/禁用
     * @param oid
     * @param enabled
     * @return
     */
    ResultBean enabled(Long oid, Byte enabled);


}
