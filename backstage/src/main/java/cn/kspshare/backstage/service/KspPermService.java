package cn.kspshare.backstage.service;

import cn.kspshare.domain.KspPerm;

import java.util.List;

public interface KspPermService {
    /**
     * 根据角色id查找权限列表
     * @param roleId
     * @return
     */
    List<KspPerm> listByRoleId(Long roleId);

    /**
     * 根据用户id查找权限值
     * @param userId
     * @return
     */
    List<String> listResourceIdByUser(Long userId);
}
