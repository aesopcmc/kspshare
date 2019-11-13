package cn.kspshare.backstage.service.impl;

import cn.kspshare.backstage.restful.ResultBean;
import cn.kspshare.backstage.service.TestService;
import cn.kspshare.domain.KspUser;
import cn.kspshare.mapper.KspUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private KspUserMapper userMapper;

    @Override
    public ResultBean list() {
        List<KspUser> kspUserList = userMapper.selectByExample().build().execute();
        return ResultBean.SUCCESS(kspUserList);
    }
}


