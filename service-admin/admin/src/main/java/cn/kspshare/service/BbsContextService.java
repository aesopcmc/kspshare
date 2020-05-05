package cn.kspshare.service;

import cn.kspshare.domain.BbsContext;
import com.github.pagehelper.PageInfo;

/**
 * 《由Mybatis Generator extend插件自动生成》
 * 
 * @author Mybatis Generator
 * @date 2020-05-05
 */
public interface BbsContextService {
    /**
     * 添加
     * @param po
     * @return
     */
    int add(BbsContext po);

    /**
     * 修改
     * @param po
     * @return
     */
    int update(BbsContext po);

    /**
     * 删除
     * @param oid
     * @return
     */
    int delete(Long oid);

    /**
     * 基本条件查询
     * @param pageNum 当前页码
     * @param pageSize 每页显示数量
     * @return
     */
    PageInfo<BbsContext> queryCondition(int pageNum, int pageSize);
}