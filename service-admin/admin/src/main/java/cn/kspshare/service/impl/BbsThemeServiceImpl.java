package cn.kspshare.service.impl;

import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.dao.BbsThemeDao;
import cn.kspshare.domain.BbsContext;
import cn.kspshare.domain.BbsTheme;
import cn.kspshare.dto.CreateArticleDto;
import cn.kspshare.mapper.BbsContextDynamicSqlSupport;
import cn.kspshare.mapper.BbsContextMapper;
import cn.kspshare.mapper.BbsThemeMapper;
import cn.kspshare.service.BbsThemeService;
import cn.kspshare.vo.ArticleVO;
import cn.kspshare.vo.ListArticleVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.BeanUtils;
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
    @Autowired
    private BbsContextMapper bbsContextMapper;
    @Autowired
    private BbsThemeDao bbsThemeDao;
    /**
     * 添加
     * @param po
     * @return
     */
    @Override
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
    @Override
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
    public PageInfo<ListArticleVO> listArticle(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        // List<BbsTheme> select = mapper.select(c -> c);
        List<ListArticleVO> select = bbsThemeDao.listArticle();
        return new PageInfo<>(select);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int createOrUpdateArticle(CreateArticleDto dto) {
        if (StringUtils.isBlank(dto.getTitle())
                || StringUtils.isBlank(dto.getContent())
                || dto.getCreateUser() == null
                || dto.getPublishStatus() == null
                || dto.getSessionId() == null) {
            throw new RuntimeException("参数不全！");
        }

        if(dto.getThemeId() == null){
            //新增

            //创建主题
            BbsTheme bbsTheme = new BbsTheme();
            BeanUtils.copyProperties(dto, bbsTheme);
            bbsTheme.setOid(IDGenerator.id());
            mapper.insertSelective(bbsTheme);

            //创建上下文
            BbsContext bbsContext = new BbsContext();
            bbsContext.setOid(IDGenerator.id());
            bbsContext.setThemeId(bbsTheme.getOid());
            bbsContext.setContextType((byte)0);
            bbsContext.setAuditStatus((byte)1);
            bbsContext.setPublishStatus(dto.getPublishStatus());
            bbsContext.setContext(dto.getContent());
            bbsContext.setCreateUser(dto.getCreateUser());
            bbsContext.setProfile(dto.getProfile());
            bbsContextMapper.insertSelective(bbsContext);
        }else {
            //更改

            Optional<BbsTheme> optional = mapper.selectByPrimaryKey(dto.getThemeId());
            if(!optional.isPresent()) {
                throw new RuntimeException("对象不存在！");
            }
            BbsTheme bbsTheme = optional.get();
            List<BbsContext> contextList = bbsContextMapper.select(c ->
                    c.where(BbsContextDynamicSqlSupport.themeId, SqlBuilder.isEqualTo(bbsTheme.getOid()))
                    .and(BbsContextDynamicSqlSupport.contextType, SqlBuilder.isEqualTo((byte) 0)));
            BbsContext bbsContext = contextList.get(0);

            bbsTheme.setTitle(dto.getTitle());
            bbsTheme.setSessionId(dto.getSessionId());
            bbsTheme.setProfile(dto.getProfile());
            bbsTheme.setUpdateUser(dto.getCreateUser());
            bbsTheme.setUpdateTime(LocalDateTime.now());
            mapper.updateByPrimaryKey(bbsTheme);

            bbsContext.setPublishStatus(dto.getPublishStatus());
            bbsContext.setContext(dto.getContent());
            bbsContext.setProfile(dto.getProfile());
            bbsContext.setUpdateTime(LocalDateTime.now());
            bbsContext.setUpdateUser(dto.getCreateUser());
            bbsContextMapper.updateByPrimaryKey(bbsContext);
        }
        return 1;
    }

    @Override
    public ArticleVO getArticle(Long articleId) {
        return bbsThemeDao.getArticle(articleId);
    }
}