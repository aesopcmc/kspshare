package cn.kspshare.service;

import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.domain.Role;
import cn.kspshare.dto.KspRoleDto;

import java.util.List;

public interface RoleService {
    /**
     * 添加
     * @param dto
     * @return
     */
    ResultBean add(KspRoleDto dto);

    /**
     * 更新
     * @param dto
     * @return
     */
    ResultBean update(KspRoleDto dto, Long oid);

    /**
     * 删除
     * @param oid
     * @return
     */
    ResultBean delete(Long oid);

    /**
     * 根据角色编码查询
     * @param code
     * @return
     */
    Role findByCode(String code);

    /**
     * 根据用户查找角色列表
     * @param userId
     * @return
     */
    List<Role> listByAdminUserId(Long userId);
}
