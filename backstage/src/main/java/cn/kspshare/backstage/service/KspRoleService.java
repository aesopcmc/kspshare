package cn.kspshare.backstage.service;

import cn.kspshare.domain.KspRole;

import java.util.List;

public interface KspRoleService {
    /**
     * 根据用户查找角色列表
     * @param userId
     * @return
     */
    List<KspRole> listByAdminUserId(Long userId);
}
