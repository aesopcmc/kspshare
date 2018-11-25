package cn.kspshare.controller;

import cn.kspshare.domain.TestUser;
import cn.kspshare.dto.request.TestUserDto;
import cn.kspshare.service.TestUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@ResponseBody
@Api(description = "用户管理")
public class TestUserController {
    @Autowired
    private TestUserService userService;

    @ApiOperation("根据主键查找")
    @GetMapping("/test/user/{id}")
    public Object getById(@PathVariable("id") Long id){
        TestUser user = userService.findById(id);
        return user;
    }

    @ApiOperation("查找所有")
    @GetMapping("/test/user/list")
    public Object list(){
        return userService.list();
    }

    @ApiOperation("按分页查找")
    @GetMapping("/test/user/listByPage")
    public Object listByPage(@RequestParam(name = "第n页") Integer pageNum,
                             @RequestParam(name = "每页显示条数") Integer pageSize){
        return userService.listByPage(pageNum, pageSize);
    }

    @ApiOperation("根据姓名模糊查找")
    @GetMapping("/test/user/findByName")
    public Object findByName(@RequestParam(name = "用户名", required = false) String userName){
        return userService.findByName(userName);
    }

    @ApiOperation("查找用户等级信息")
    @GetMapping("/test/user/findUserGrade")
    public Object findUserGrade(@RequestParam(name = "年龄", required = false) Integer age,
                                @RequestParam(name = "用户名", required = false) String userName,
                                @RequestParam(name = "等级",required = false) Integer level){
        return userService.findUserGrade(age, userName, level);
    }

    @ApiOperation("新增用户")
    @PostMapping("/test/user/saveUser")
    public Object saveUser(@RequestBody @Valid TestUserDto userDto, BindingResult result){
        if(result.hasErrors()){
            return result.getFieldError().getDefaultMessage();
        }
        return userService.saveUser(userDto);
    }


}
