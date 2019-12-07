package cn.kspshare;

import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.domain.KspMember;
import cn.kspshare.domain.TestUser;
import cn.kspshare.mapper.KspMemberDynamicSqlSupport;
import cn.kspshare.mapper.KspMemberMapper;
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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static org.mybatis.dynamic.sql.SqlBuilder.isLike;


@RunWith(SpringRunner.class)
@SpringBootTest()
@MapperScan({"cn.kspshare.mapper","cn.kspshare.dao"})
public class ApplicationTests {
    @Autowired
    private TestUserMapper userMapper;
    @Autowired
    private KspMemberMapper kspUserMapper;

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

    /**
     * 密码加密
     * chao 123
     * admin 000
     */
    @Test
    public void getPasswordEncoder(){
        String password = new BCryptPasswordEncoder().encode("123456");
        System.out.println(password);
    }

    @Test
    public void test3(){
        Long execute = kspUserMapper.countByExample().build().execute();
        System.out.println("总数量"+execute);

        List<KspMember> allList = kspUserMapper.selectByExample().build().execute();
        System.out.println(111);

        //模糊查询
        List<KspMember> conditionList = kspUserMapper.selectByExample()
                .where(KspMemberDynamicSqlSupport.username, isLike("%chao%"))
                .and(KspMemberDynamicSqlSupport.nickname, isLike("超%"))
                //.orderBy(KspMemberDynamicSqlSupport.email)
                .build()
                .execute();
        conditionList.forEach(po-> System.out.println(po.toString()));
    }

    @Test
    public void testAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
            try {
                System.out.println("doing...");
                TimeUnit.SECONDS.sleep(2000);
                System.out.println("doing end");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        //future.get();
        if(future.isDone()){
            System.out.println("结束1");
        }

        System.out.println("结束2");
    }



}
