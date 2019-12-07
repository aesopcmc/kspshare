package cn.kspshare.service;

import cn.kspshare.domain.TestUser;
import cn.kspshare.dto.request.TestUserDto;

import java.util.List;
import java.util.Map;

public interface TestUserService {

    TestUser findById(Long id);

    List<TestUser> list();

    Object listByPage(Integer pageNum, Integer pageSize);

    List<TestUser> findByName(String userName);

    List<Map<String, Object>> findUserGrade(Integer age, String userName, Integer level);

    Object saveUser(TestUserDto userDto);
}
