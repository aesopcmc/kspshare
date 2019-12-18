package cn.kspshare.service;

import cn.kspshare.domain.KspPerm;

import java.util.List;

public interface KspPermService {
    /**
     * 根据角色id查找权限列表
     * @param roleId
     * @return
     */
    List<KspPerm> listByRole(Long roleId);

    /**
     * 根据用户id查找权限列表 TODO 未完善
     * @param userId
     * @return
     */
    List<String> listByUser(Long userId);
}
