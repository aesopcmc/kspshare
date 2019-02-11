# spring security的使用
### 1.1 引入依赖

### **1.2  spring security标签的使用**
* 引入maven
```html
<dependency>
  <groupId>org.springframework.security</groupId>
  <artifactId>spring-security-taglibs</artifactId> 
</dependency>  

<dependency>
  <groupId>javax.servlet.jsp</groupId>
  <artifactId>jsp-api</artifactId>
  <version>2.2.1-b03</version> 
</dependency>
```

* 依赖引入后到spring-security-taglibs包中META-INF下security.tld复制出来，放到/resources/static下，最后建一个目录tags

* 编写配置文件：创建配置类`MyConfiguration.java`
```java
@Configuration 
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MyConfiguration {
  @Autowired
  private FreeMarkerConfigurer configurer;    
  
  @PostConstruct
  public void freeMarkerConfigurer() {
    List<String> tlds = new ArrayList<>();
    tlds.add("/static/tags/security.tld");
    TaglibFactory taglibFactory = configurer.getTaglibFactory();
    taglibFactory.setClasspathTlds(tlds);
    if(taglibFactory.getObjectWrapper() == null) {
      taglibFactory.setObjectWrapper(configurer.getConfiguration().getObjectWrapper());
    }
  }
}
```



* 在freemarker页面模板引入标签
```html
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
```

* 判断是否登录控制页面元素显示
```html

<!-- 判断是否登录 -->
<@security.authorize access="isAuthenticated()"><!-- 也可以取反 !isAuthenticated()-->
  <!-- 要显示的页面元素 -->
</@security.authorize>

<!-- 判断权限，根据权限值显示页面元素 -->
<@security.authorize access="hasRole('ROLE_USER')">
  <!-- 要显示的页面元素 -->
</@security.authorize>
```


