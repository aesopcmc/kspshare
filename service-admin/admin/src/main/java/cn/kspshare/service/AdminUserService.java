package cn.kspshare.service;

import cn.kspshare.domain.AdminUser;
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
     * 根据ID查找用户胡
     * @param oid
     * @return
     */
    AdminUser queryById(Long oid);

    /**
     * 用户名查找
     * @param username
     * @return
     */
    AdminUser queryByUsername(String username);

    /**
     * 组合条件查询
     * @param dto
     * @return
     */
    ResultBean queryByCondition(KspAdminUserListConditionDto dto);

    /**
     * 启用/禁用
     * @param oid
     * @param enabled
     * @return
     */
    ResultBean enabled(Long oid, Byte enabled);
}
