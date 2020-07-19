package cn.kspshare.service.impl;

import cn.kspshare.domain.AdminUser;
import cn.kspshare.mapper.AdminUserMapper;
import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private AdminUserMapper userMapper;

    @Override
    public ResultBean list() {
        List<AdminUser> kspUserList = userMapper.select(c -> c);
        return ResultBean.SUCCESS().setData(kspUserList);
    }
}


