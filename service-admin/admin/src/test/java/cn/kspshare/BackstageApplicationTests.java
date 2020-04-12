package cn.kspshare;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
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
        // String password = new BCryptPasswordEncoder().encode("123456");
        // System.out.println(password);
        //$2a$10$x8liSDICXIz/u1N/ijZ/9.E0Penc2mwa8Hs6QUkvn/elMH6PNf4Zm
        //539231828473544704
    }


}
