package cn.kspshare.service.impl;

import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.domain.BbsSession;
import cn.kspshare.dto.BaseSearchDto;
import cn.kspshare.mapper.BbsSessionDynamicSqlSupport;
import cn.kspshare.mapper.BbsSessionMapper;
import cn.kspshare.service.BbsSessionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BbsSessionServiceImpl implements BbsSessionService {
    @Autowired
    private BbsSessionMapper mapper;

    @Override
    @Transactional(rollbackFor = Exception.class )
    public int add(BbsSession po) {
        BbsSession exist = this.queryByName(po.getName());
        if(exist!=null) {
            throw new RuntimeException("模块名称已存在！");
        }

        po.setOid(IDGenerator.id());
        po.setCreateTime(LocalDateTime.now());
        po.setUpdateUser(null);
        po.setUpdateTime(null);

        return mapper.insertSelective(po);
    }

    @Override
    @Transactional(rollbackFor = Exception.class )
    public int update(BbsSession po) {
        if(po.getOid()==null) {
            throw new RuntimeException("主键不能为空！");
        }
        po.setCreateTime(null);
        po.setCreateUser(null);
        po.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(po);
    }

    @Override
    @Transactional(rollbackFor = Exception.class )
    public int delete(Long oid) {
        return mapper.deleteByPrimaryKey(oid);
    }

    @Override
    public PageInfo<BbsSession> queryCondition(BaseSearchDto param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());

        List<BbsSession> select = mapper.select(c ->
                c.where(BbsSessionDynamicSqlSupport.name, SqlBuilder.isLike("%"+param.getSearchText()+"%"))
                .or(BbsSessionDynamicSqlSupport.profile, SqlBuilder.isLike("%"+param.getSearchText()+"%")));
        return new PageInfo<>(select);
    }

    @Override
    public BbsSession queryByName(String name) {
        List<BbsSession> select = mapper.select(c -> c.where(BbsSessionDynamicSqlSupport.name, SqlBuilder.isEqualTo(name)));
        return CollectionUtils.isEmpty(select) ? null : select.get(0);
    }

    @Override
    public List<BbsSession> select() {
        return mapper.select(c -> c);
    }
}
