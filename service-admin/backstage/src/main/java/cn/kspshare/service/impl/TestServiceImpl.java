package cn.kspshare.service.impl;

import cn.kspshare.domain.KspAdminUser;
import cn.kspshare.mapper.KspAdminUserMapper;
import cn.kspshare.restful.ResultBean;
import cn.kspshare.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private KspAdminUserMapper userMapper;

    @Override
    public ResultBean list() {
        List<KspAdminUser> kspUserList = userMapper.selectByExample().build().execute();
        return ResultBean.SUCCESS(kspUserList);
    }
}


