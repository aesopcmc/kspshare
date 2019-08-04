package cn.kspshare.backstage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@MapperScan({"cn.kspshare.mapper","cn.kspshare.dao"})
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
public class BackstageApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(BackstageApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BackstageApplication.class, args);
    }


}
