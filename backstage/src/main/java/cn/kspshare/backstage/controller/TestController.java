package cn.kspshare.backstage.controller;

import cn.kspshare.backstage.restful.ResultBean;
import cn.kspshare.backstage.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@Api(description = "测试接口")
public class TestController {
    @Autowired
    private TestService testService;

    @ApiOperation("查找所有")
    @GetMapping("/test/list")
    public ResultBean list(){
        return testService.list();
    }

}
