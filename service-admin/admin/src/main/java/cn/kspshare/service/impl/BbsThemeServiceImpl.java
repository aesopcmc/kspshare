package cn.kspshare.service.impl;

import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.domain.BbsTheme;
import cn.kspshare.mapper.BbsThemeDynamicSqlSupport;
import cn.kspshare.mapper.BbsThemeMapper;
import cn.kspshare.service.BbsThemeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.time.LocalDateTime;
import java.util.List;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 《由Mybatis Generator extend插件自动生成》
 * 
 * @author Mybatis Generator
 * @date 2020-05-05
 */
@Service
public class BbsThemeServiceImpl implements BbsThemeService {
    @Autowired
    private BbsThemeMapper mapper;

    /**
     * 添加
     * @param po
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int add(BbsTheme po) {
        po.setOid(IDGenerator.id());
        po.setCreateTime(LocalDateTime.now());
        po.setUpdateUser(null);
        po.setUpdateTime(null);
        return mapper.insertSelective(po);
    }

    /**
     * 修改
     * @param po
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int update(BbsTheme po) {
        if(po.getOid()==null) {
            throw new RuntimeException("主键不能为空！");
        }
        po.setCreateTime(null);
        po.setCreateUser(null);
        po.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(po);
    }

    /**
     * 删除
     * @param oid
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int delete(Long oid) {
        return mapper.deleteByPrimaryKey(oid);
    }

    /**
     * 基本条件查询
     * @param pageNum 当前页码
     * @param pageSize 每页显示数量
     * @return
     */
    public PageInfo<BbsTheme> queryCondition(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<BbsTheme> select = mapper.select(c -> c);
        return new PageInfo<>(select);
    }
}