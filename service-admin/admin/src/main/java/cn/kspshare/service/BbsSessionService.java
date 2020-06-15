package cn.kspshare.service;

import cn.kspshare.domain.BbsSession;
import cn.kspshare.dto.BaseSearchDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BbsSessionService {
    /**
     * 添加
     * @param po
     * @return
     */
    int add(BbsSession po);

    /**
     * 修改
     * @param po
     * @return
     */
    int update(BbsSession po);

    /**
     * 删除
     * @param oid
     * @return
     */
    int delete(Long oid);

    /**
     * 基本条件查询
     * @return
     * @param param
     */
    PageInfo<BbsSession> queryCondition(BaseSearchDto param);

    /**
     * 根据名称查找
     * @param name
     * @return
     */
    BbsSession queryByName(String name);

    /**
     * 查找下拉列表
     * @return
     */
    List<BbsSession> select();

}
