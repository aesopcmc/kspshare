package cn.kspshare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan({"cn.kspshare.mapper","cn.kspshare.dao"})
@SpringBootApplication
public class BackstageApplication  extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(BackstageApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BackstageApplication.class, args);
    }
}
