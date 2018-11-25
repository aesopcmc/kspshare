package cn.kspshare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// mapper 接口类扫描包配置
//@MapperScan({"cn.kspshare.mapper","cn.kspshare.dao"})
@tk.mybatis.spring.annotation.MapperScan(basePackages = {"cn.kspshare.mapper","cn.kspshare.dao"})
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
