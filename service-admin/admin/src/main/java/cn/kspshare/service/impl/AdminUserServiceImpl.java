package cn.kspshare.service.impl;

import cn.kspshare.common.CommonUtils;
import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.dto.KspAdminUserDto;
import cn.kspshare.dto.KspAdminUserListConditionDto;
import cn.kspshare.mapper.KspAdminUserDynamicSqlSupport;
import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.service.AdminUserService;
import cn.kspshare.domain.KspAdminUser;
import cn.kspshare.mapper.KspAdminUserMapper;
import cn.kspshare.utils.AdminUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private KspAdminUserMapper adminUserMapper;

    @Override
    @Transactional(rollbackFor = Exception.class )
    public ResultBean add(KspAdminUserDto dto) {
        KspAdminUser exist = this.findByUsername(dto.getUsername());
        if(exist!=null) {
            return ResultBean.FAIL("用户名已存在！");
        }

        KspAdminUser domain = new KspAdminUser();
        BeanUtils.copyProperties(dto, domain);
        domain.setOid(IDGenerator.id());
        //设置初始密码
        domain.setPassword(AdminUtils.passwordEncode("123456"));
        adminUserMapper.insertSelective(domain);
        return ResultBean.SUCCESS();
    }

    @Override
    @Transactional(rollbackFor = Exception.class )
    public ResultBean update(KspAdminUserDto dto) {
        KspAdminUser exist = this.findByUsername(dto.getUsername());
        if(exist!=null && !exist.getOid().equals(dto.getOid())) {
            return ResultBean.FAIL("用户名已存在！");
        }

        KspAdminUser updateRecord = new KspAdminUser();
        BeanUtils.copyProperties(dto, updateRecord);
        updateRecord.setUpdateTime(LocalDateTime.now());
        adminUserMapper.updateByPrimaryKeySelective(updateRecord);
        return ResultBean.SUCCESS();
    }

    @Override
    @Transactional(rollbackFor = Exception.class )
    public ResultBean delete(Long oid) {
        adminUserMapper.deleteByPrimaryKey(oid);

        //todo 删除权限关系
        return ResultBean.SUCCESS();
    }

    @Override
    public ResultBean listCondition(KspAdminUserListConditionDto dto) {

        //复杂组合条件查询
        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder builder = select(
                KspAdminUserDynamicSqlSupport.oid,
                KspAdminUserDynamicSqlSupport.username,
                KspAdminUserDynamicSqlSupport.realname,
                KspAdminUserDynamicSqlSupport.gender,
                KspAdminUserDynamicSqlSupport.email,
                KspAdminUserDynamicSqlSupport.enabled,
                KspAdminUserDynamicSqlSupport.createTime,
                KspAdminUserDynamicSqlSupport.createUser)
                .from(KspAdminUserDynamicSqlSupport.kspAdminUser)
                .where();
        if(!CommonUtils.isEmpty(dto.getUserNameOrRealNameOrEmail())) {
            builder.and(KspAdminUserDynamicSqlSupport.username, isLike("%" + dto.getUserNameOrRealNameOrEmail() + "%"),
                    or(KspAdminUserDynamicSqlSupport.realname, isLike("%" + dto.getUserNameOrRealNameOrEmail() + "%")),
                    or(KspAdminUserDynamicSqlSupport.email, isLike("%" + dto.getUserNameOrRealNameOrEmail() + "%")));
        }
        if(dto.getGender()!=null) {
            builder.and(KspAdminUserDynamicSqlSupport.gender, isEqualTo(dto.getGender()));
        }
        if(dto.getEnabled()!=null) {
            builder.and(KspAdminUserDynamicSqlSupport.enabled, isEqualTo(dto.getEnabled()));
        }
        builder.orderBy(KspAdminUserDynamicSqlSupport.createTime.descending());//descending()降序排序，没有这个默认升序

        SelectStatementProvider render = builder.build().render(RenderingStrategies.MYBATIS3);

        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        List<KspAdminUser> list = adminUserMapper.selectMany(render);
        PageInfo<KspAdminUser> pageInfo = new PageInfo<>(list);

        return ResultBean.SUCCESS(pageInfo);
    }

    @Override
    public KspAdminUser findByUsername(String username) {
        List<KspAdminUser> list = adminUserMapper.select(c -> c.where(KspAdminUserDynamicSqlSupport.username, isEqualTo(username)));
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    @Transactional(rollbackFor = Exception.class )
    public ResultBean enabled(Long oid, Byte enabled) {
        if(oid!=null && enabled!=null) {
            return ResultBean.SUCCESS();
        }else {
            return ResultBean.FAIL();
        }
    }
}
