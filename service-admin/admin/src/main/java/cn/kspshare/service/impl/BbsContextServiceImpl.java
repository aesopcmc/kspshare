package cn.kspshare.service.impl;

import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.dao.BbsContextDao;
import cn.kspshare.domain.BbsContext;
import cn.kspshare.domain.BbsTheme;
import cn.kspshare.vo.ContentVo;
import cn.kspshare.mapper.BbsContextMapper;
import cn.kspshare.mapper.BbsThemeMapper;
import cn.kspshare.service.BbsContextService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

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
public class BbsContextServiceImpl implements BbsContextService {
    @Autowired
    private BbsContextMapper mapper;
    @Autowired
    private BbsContextDao contextDao;
    @Autowired
    private BbsThemeMapper bbsThemeMapper;
    /**
     * 添加
     * @param po
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int add(BbsContext po) {
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
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(BbsContext po) {
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
    @Override
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
    @Override
    public PageInfo<BbsContext> queryCondition(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<BbsContext> select = mapper.select(c -> c);
        return new PageInfo<>(select);
    }

    @Override
    public Map<String, Object> showContent(Long themeId, Integer pageNum, Integer pageSize) {
        AtomicReference<BbsTheme> themeAtom = new AtomicReference<>();
        bbsThemeMapper.selectByPrimaryKey(themeId).ifPresent(themeAtom::set);
        BbsTheme theme = themeAtom.get();
        if(theme==null){
            throw new RuntimeException("主题为空");
        }

        PageHelper.startPage(pageNum, pageSize);
        List<ContentVo> contentList =  contextDao.showContent(themeId);
        PageInfo<ContentVo> pageInfo = new PageInfo<>(contentList);

        Map<String, Object> data = new HashMap<>();
        data.put("theme", theme);
        data.put("pageInfo", pageInfo);
        return data;
    }
}