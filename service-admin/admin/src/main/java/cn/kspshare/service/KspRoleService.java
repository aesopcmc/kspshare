package cn.kspshare.service;

import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.domain.KspRole;
import cn.kspshare.dto.KspRoleDto;

import java.util.List;

public interface KspRoleService {
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
    KspRole findByCode(String code);

    /**
     * 根据用户查找角色列表
     * @param userId
     * @return
     */
    List<KspRole> listByAdminUserId(Long userId);
}
