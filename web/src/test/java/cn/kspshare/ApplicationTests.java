package cn.kspshare;

import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.domain.KspUser;
import cn.kspshare.domain.TestUser;
import cn.kspshare.mapper.KspUserDynamicSqlSupport;
import cn.kspshare.mapper.KspUserMapper;
import cn.kspshare.mapper.TestUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

import static org.mybatis.dynamic.sql.SqlBuilder.isLike;


@RunWith(SpringRunner.class)
@SpringBootTest()
@MapperScan({"cn.kspshare.mapper","cn.kspshare.dao"})
public class ApplicationTests {
    @Autowired
    private TestUserMapper userMapper;
    @Autowired
    private KspUserMapper kspUserMapper;

    @Test
    public void test(){
        TestUser user = new TestUser();
        user.setTid(IDGenerator.id());
        user.setUserName("王思聪2222");
        user.setAge(30);
        userMapper.insertSelective(user);
    }

    @Test
    public void test2(){
        for(int i = 0;i<100;i++){
            TestUser user = new TestUser();
            user.setTid(IDGenerator.id());
            user.setUserName("王思聪"+i);
            Random r = new Random();
            user.setAge(r.nextInt());
            userMapper.insertSelective(user);
        }
    }

    @Test
    public void getPasswordEncoder(){
        String password = new BCryptPasswordEncoder().encode("123");
        System.out.println(password);

    }

    @Test
    public void test3(){
        Long execute = kspUserMapper.countByExample().build().execute();
        System.out.println("总数量"+execute);

        List<KspUser> allList = kspUserMapper.selectByExample().build().execute();
        System.out.println(111);

        //模糊查询
        List<KspUser> conditionList = kspUserMapper.selectByExample()
                .where(KspUserDynamicSqlSupport.username, isLike("%chao%"))
                .and(KspUserDynamicSqlSupport.nickname, isLike("超%"))
                //.orderBy(KspUserDynamicSqlSupport.email)
                .build()
                .execute();
        conditionList.forEach(po-> System.out.println(po.toString()));


    }


}
