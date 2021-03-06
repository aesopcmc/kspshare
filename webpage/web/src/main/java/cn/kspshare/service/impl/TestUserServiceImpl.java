package cn.kspshare.service.impl;

import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.dao.TestUserDao;
import cn.kspshare.domain.TestUser;
import cn.kspshare.dto.request.TestUserDto;
import cn.kspshare.mapper.TestUserDynamicSqlSupport;
import cn.kspshare.mapper.TestUserMapper;
import cn.kspshare.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.namespace.QName;
import java.util.List;
import java.util.Map;

@Service
public class TestUserServiceImpl implements TestUserService {
    @Autowired
    private TestUserMapper testUserMapper;
    @Autowired
    private TestUserDao testUserDao;

    public TestUser findById(Long id){
        return testUserMapper.selectByPrimaryKey(id).get();
    }

    @Override
    public List<TestUser> list() {
        List<TestUser> list = testUserMapper.select(c->c);
        return list;
        /*
        多条件查询
         */
        //方式一：
        //Example exp = new Example(TestUser.class);
        //exp.setForUpdate(true);
        //exp.createCriteria()
        //        .andGreaterThan("age", 20)
        //        .andLessThan("age", 40);
        //List<TestUser> userList = testUserMapper.selectByExample(exp);

        //方式二,推荐使用，这样，以后更改实体字段名称也容易发现位置
        //Example example = new Example.Builder(TestUser.class).andWhere(WeekendSqls.<TestUser>custom()
        //        .andGreaterThan(TestUser::getAge, 20)
        //        .andLessThan(TestUser::getAge, 40))
        //        .build();
        /*
        参考更多方式
        .select("countryname")
        .where(Sqls.custom().andGreaterThan("id", 100))
        .orderByAsc("countrycode")
        .forUpdate()
        .build();

         */
        //return testUserMapper.selectByExample(example);
    }

    @Override
    public Object listByPage(Integer pageNum, Integer pageSize) {
        //PageHelper.startPage(pageNum, pageSize);
        //List<TestUser> userList = testUserMapper.selectAll();
        //PageInfo pageInfo = new PageInfo(userList);
        //return pageInfo;

        return null;
    }

    @Override
    public List<TestUser> findByName(String userName) {
        //Example example = new Example(TestUser.class);
        //
        ////example.selectProperties("tid", "userName","age");//设置查询的列
        //
        //Example.Criteria criteria = example.createCriteria();
        //if(!StringUtils.isEmpty(userName)){
        //    //模糊查询
        //    criteria.andLike("userName", "%"+userName+"%");
        //}
        ////排序
        //example.orderBy("age").desc().orderBy("tid").asc();
        //
        //List<TestUser> testUsers = testUserMapper.selectByExample(example);
        //return testUsers;

        return null;
    }

    @Override
    public List<Map<String, Object>> findUserGrade(Integer age, String userName, Integer level) {
        return testUserDao.findUserAndGradeGreaterAge(age, userName, level);
    }

    @Override
    @Transactional
    public Object saveUser(TestUserDto userDto) {
        TestUser user = new TestUser();
        user.setTid(IDGenerator.id());
        user.setUserName(userDto.getUserName());
        user.setAge(userDto.getAge());
        user.setGradeId(userDto.getGradeId());
        testUserMapper.insertSelective(user);
        return "success";
    }
}
