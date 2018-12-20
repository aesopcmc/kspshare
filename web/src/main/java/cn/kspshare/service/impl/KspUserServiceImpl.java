package cn.kspshare.service.impl;

import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.constant.BaseConstant;
import cn.kspshare.domain.KspUser;
import cn.kspshare.mapper.KspUserMapper;
import cn.kspshare.selectUtil.SelectBuilder;
import cn.kspshare.service.KspUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.WeekendSqls;

import java.util.List;

@Service
public class KspUserServiceImpl implements KspUserService {
    @Autowired
    private KspUserMapper userMapper;
    @Autowired
    private BaseConstant baseConstant;

    @Override
    public KspUser findByUserName(String username) {
        WeekendSqls<KspUser> custom = SelectBuilder.getCustom();
        custom.andEqualTo(KspUser::getUsername, username);
        Example example = SelectBuilder.getExample(custom, KspUser.class);
        List<KspUser> kspUsers = userMapper.selectByExample(example);
        return CollectionUtils.isEmpty(kspUsers) ? null : kspUsers.get(0);
    }

    @Override
    public boolean doRegister(KspUser kspUser) {
        if(StringUtils.isEmpty(kspUser.getUsername()) || StringUtils.isEmpty(kspUser.getPassword())){
            return false;
        }
        if(this.findByUserName(kspUser.getUsername())!=null){
            return false;
        }
        //使用spring security密码加密
        String password = new BCryptPasswordEncoder().encode(kspUser.getPassword());
        kspUser.setPassword(password);
        kspUser.setOid(IDGenerator.id());
        kspUser.setNickname(kspUser.getUsername());
        kspUser.setRoles(baseConstant.ROLE_USER);
        int i = userMapper.insertSelective(kspUser);
        return i==1;
    }

}
