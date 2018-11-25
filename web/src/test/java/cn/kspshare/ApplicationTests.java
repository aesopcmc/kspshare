package cn.kspshare;

import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.domain.TestUser;
import cn.kspshare.mapper.TestUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;


@RunWith(SpringRunner.class)
@SpringBootTest()
@tk.mybatis.spring.annotation.MapperScan(basePackages = "cn.kspshare.mapper")
public class ApplicationTests {
    @Autowired
    private TestUserMapper userMapper;

    @Test
    public void test(){
        TestUser user = new TestUser();
        user.setTid(IDGenerator.id());
        user.setUserName("王思聪");
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

}
