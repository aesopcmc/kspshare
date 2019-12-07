package cn.kspshare;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackstageApplicationTests {

    @Test
    public void contextLoads() {
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


}
