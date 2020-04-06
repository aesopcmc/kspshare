package cn.kspshare.service;

import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.domain.KspPerm;
import cn.kspshare.dto.PermDto;
import lombok.Data;

import java.util.List;

public interface PermService {
    /**
     * 根据角色id查找权限列表
     * @param roleId
     * @return
     */
    @Deprecated
    List<KspPerm> listByRole(Long roleId);

    /**
     * 根据用户id查找权限列表 TODO 未完善
     * @param userId
     * @return
     */
    @Deprecated
    List<String> listByUser(Long userId);

    ResultBean add(PermDto dto);

    ResultBean update(PermDto dto, Long oid);

    ResultBean delete(Long oid);

    /**
     * 根据资源ID查找权限列表
     * @param resourceId
     * @return
     */
    ResultBean listByResource(Long resourceId);

}
