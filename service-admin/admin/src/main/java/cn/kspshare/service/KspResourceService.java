package cn.kspshare.service;

import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.dto.KspResourceDto;

/**
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/12/24 17:51
 */
public interface KspResourceService {
    /**
     * 添加
     * @param dto
     * @return
     */
    ResultBean add(KspResourceDto dto);

    /**
     * 修改
     * @param dto
     * @return
     */
    ResultBean update(KspResourceDto dto);

    /**
     * 删除
     * @param oid
     * @return
     */
    ResultBean delete(Long oid);

    /**
     * 属性列表
     * @return
     */
    ResultBean treeList();

}
