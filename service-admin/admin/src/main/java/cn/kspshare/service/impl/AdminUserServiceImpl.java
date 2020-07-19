package cn.kspshare.service.impl;

import cn.kspshare.common.CommonUtils;
import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.dto.KspAdminUserDto;
import cn.kspshare.dto.KspAdminUserListConditionDto;
import cn.kspshare.mapper.AdminUserDynamicSqlSupport;
import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.service.AdminUserService;
import cn.kspshare.domain.AdminUser;
import cn.kspshare.mapper.AdminUserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    @Transactional(rollbackFor = Exception.class )
    public ResultBean add(KspAdminUserDto dto) {
        AdminUser exist = this.queryByUsername(dto.getUsername());
        if(exist!=null) {
            return ResultBean.FAIL("用户名已存在！");
        }

        AdminUser domain = new AdminUser();
        BeanUtils.copyProperties(dto, domain);
        domain.setOid(IDGenerator.id());
        //设置初始密码
        domain.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes())); //密码加密
        adminUserMapper.insertSelective(domain);
        return ResultBean.SUCCESS();
    }

    @Override
    @Transactional(rollbackFor = Exception.class )
    public ResultBean update(KspAdminUserDto dto) {
        AdminUser exist = this.queryByUsername(dto.getUsername());
        if(exist!=null && !exist.getOid().equals(dto.getOid())) {
            return ResultBean.FAIL("用户名已存在！");
        }

        AdminUser updateRecord = new AdminUser();
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
    public AdminUser queryById(Long oid) {
        //TOdo 处理selectOne报错问题

        // Optional<KspAdminUser> kspAdminUser = adminUserMapper.selectOne(c -> c.where(KspAdminUserDynamicSqlSupport.oid, isEqualTo(oid)));
        // Optional<KspAdminUser> kspAdminUser = adminUserMapper.selectByPrimaryKey(oid);

        List<AdminUser> select = adminUserMapper.select(c -> c.where(AdminUserDynamicSqlSupport.oid, isEqualTo(oid)));
        return select.get(0);
        // return kspAdminUser.orElse(null);
    }

    @Override
    public ResultBean queryByCondition(KspAdminUserListConditionDto dto) {

        //复杂组合条件查询
        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder builder = select(
                AdminUserDynamicSqlSupport.oid,
                AdminUserDynamicSqlSupport.username,
                AdminUserDynamicSqlSupport.realname,
                AdminUserDynamicSqlSupport.gender,
                AdminUserDynamicSqlSupport.email,
                AdminUserDynamicSqlSupport.enabled,
                AdminUserDynamicSqlSupport.createTime,
                AdminUserDynamicSqlSupport.createUser)
                .from(AdminUserDynamicSqlSupport.adminUser)
                .where();
        if(!CommonUtils.isEmpty(dto.getUserNameOrRealNameOrEmail())) {
            builder.and(AdminUserDynamicSqlSupport.username, isLike("%" + dto.getUserNameOrRealNameOrEmail() + "%"),
                    or(AdminUserDynamicSqlSupport.realname, isLike("%" + dto.getUserNameOrRealNameOrEmail() + "%")),
                    or(AdminUserDynamicSqlSupport.email, isLike("%" + dto.getUserNameOrRealNameOrEmail() + "%")));
        }
        if(dto.getGender()!=null) {
            builder.and(AdminUserDynamicSqlSupport.gender, isEqualTo(dto.getGender()));
        }
        if(dto.getEnabled()!=null) {
            builder.and(AdminUserDynamicSqlSupport.enabled, isEqualTo(dto.getEnabled()));
        }
        builder.orderBy(AdminUserDynamicSqlSupport.createTime.descending());//descending()降序排序，没有这个默认升序

        SelectStatementProvider render = builder.build().render(RenderingStrategies.MYBATIS3);

        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        List<AdminUser> list = adminUserMapper.selectMany(render);
        PageInfo<AdminUser> pageInfo = new PageInfo<>(list);

        return ResultBean.SUCCESS().setData(pageInfo);
    }

    @Override
    public AdminUser queryByUsername(String username) {
        List<AdminUser> list = adminUserMapper.select(c -> c.where(AdminUserDynamicSqlSupport.username, isEqualTo(username)));
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
