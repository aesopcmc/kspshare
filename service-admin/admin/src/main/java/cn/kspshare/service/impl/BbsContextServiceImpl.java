package cn.kspshare.service.impl;

import cn.kspshare.common.CommonUtils;
import cn.kspshare.common.restful.ResultCode;
import cn.kspshare.common.restful.exception.BaseExceptionFactory;
import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.dao.BbsContextDao;
import cn.kspshare.domain.BbsContext;
import cn.kspshare.domain.BbsTheme;
import cn.kspshare.dto.ReplyDto;
import cn.kspshare.vo.ContentVO;
import cn.kspshare.mapper.BbsContextMapper;
import cn.kspshare.mapper.BbsThemeMapper;
import cn.kspshare.service.BbsContextService;
import cn.kspshare.vo.ReplyListVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.stream.events.Comment;

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
     * 删除评论、回复
     * @param oid
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(Long oid) {
        Optional<BbsContext> bbsContext = mapper.selectByPrimaryKey(oid);
        if(!bbsContext.isPresent()){
            throw BaseExceptionFactory.get("主题不允许删除");
        }
        return mapper.deleteByPrimaryKey(oid);
    }


    /**
     * 删除评论、回复
     * @param oid
     * @return
     */
    @Override
    public BbsContext selectByPrimaryKey(Long oid) {
        AtomicReference<BbsContext> bbsContext = new AtomicReference<>();
        mapper.selectByPrimaryKey(oid).ifPresent(bbsContext::set);
        return bbsContext.get();
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
        List<ContentVO> contentList =  contextDao.showContent(themeId);
        PageInfo<ContentVO> pageInfo = new PageInfo<>(contentList);

        Map<String, Object> data = new HashMap<>();
        data.put("theme", theme);
        data.put("pageInfo", pageInfo);
        return data;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int auditContent(Long contextId, Byte auditStatus) {
        if(contextId==null || auditStatus==null) {
           throw BaseExceptionFactory.get(ResultCode.MISSING_PARAMETERS);
        }

        Optional<BbsContext> optional = mapper.selectByPrimaryKey(contextId);
        if(optional.isPresent()) {
            BbsContext bbsContext = optional.get();
            bbsContext.setAuditStatus(auditStatus);
            return mapper.updateByPrimaryKeySelective(bbsContext);
        }else {
            throw BaseExceptionFactory.get("内容不存在！");
        }
    }

    @Override
    public List<ReplyListVO> replyList(Integer pageNum, Integer pageSize) {
        return contextDao.selectReplyList();
    }

    @Override
    public ReplyDto getReply(Long contextId) {
        return contextDao.getReply(contextId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateReply(ReplyDto dto) {
        if(dto.getContextId()==null || dto.getUpdateUser()==null || StringUtils.isBlank(dto.getContext())) {
            throw BaseExceptionFactory.get(ResultCode.MISSING_PARAMETERS);
        }
        AtomicReference<BbsContext> bbs = new AtomicReference<>();
        mapper.selectByPrimaryKey(dto.getContextId()).ifPresent(bbs::set);

        BbsContext bbsContext = bbs.get();
        if(bbsContext==null) {
            throw BaseExceptionFactory.get("对象不存在");
        }
        if(bbsContext.getContextType()!=1 && bbsContext.getContextType()!=2) {
            throw BaseExceptionFactory.get("不是评论、回复类型");
        }

        bbsContext.setContext(dto.getContext());
        bbsContext.setUpdateUser(dto.getUpdateUser());
        bbsContext.setUpdateTime(LocalDateTime.now());
        //从context提取摘要
        String profile = CommonUtils.htmlRemoveTag(dto.getContext());
        System.out.println(profile);
        int len = profile.length() > 20 ? 20 : profile.length();
        bbsContext.setProfile(profile.substring(0, len));

        return mapper.updateByPrimaryKeySelective(bbsContext);
    }

}