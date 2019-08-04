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
}
