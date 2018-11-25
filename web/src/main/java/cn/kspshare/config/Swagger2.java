package cn.kspshare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 【swagger配置，项目启动后访问http://localhost:8080/swagger-ui.html 即可查看API文档】
 * 通过@Configuration注解，让Spring来加载该类配置。
 * 再通过@EnableSwagger2注解来启用Swagger2。
 * <p>
 * 通过createRestApi函数创建Docket的Bean之后，apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。
 * select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，
 * 本例采用指定扫描的包路径来定义，Swagger会扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）。
 * <p>
 * Create by CMC(chao_c_c@163.com) 2018/5/27 14:50
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.kspshare.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("KspShare项目接口文档 Swagger2构建RESTful APIs")
                .description("官方KSP分享站请进：http://www.kspshare.cn/")
                .termsOfServiceUrl("http://www.kspshare.cn/")
                .contact("Aesop")
                .version("1.0")
                .build();
    }

}