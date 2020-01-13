package cn.kspshare.config;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置spring boot内嵌的Jackson序列化与反序列化类型映射
 * 定义一个配置类，在配置类注入两个 Bean 实现日期全局格式化，同时还兼顾了 Date 和 LocalDateTime 并存。
 *
 * -日期配置：
 *      map.put(LocalDateTime.class, localDateTimeSerializer());
 *      Spring Boot 提供了 spring.jackson.date-format配置可以让我们进行日期格式化，
 *      但它只能格式化 java.util.Date。
 *
 *      需要配置
 *      spring:
 *        jackson:
 *          date-format: yyyy-MM-dd HH:mm:ss
 *          time-zone: GMT+8
 *
 *  -Long类型转为字符串：
 *      map.put(Long.class, ToStringSerializer.instance);
 *      解决Long类型数据返回到前端精度丢失问题
 */
@Configuration
public class JacksonSerializerConfig {
    @Value("${spring.jackson.date-format}")
    private String pattern;

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        Map<Class<?>, JsonSerializer<?>> map = new HashMap<>();
        map.put(LocalDateTime.class, localDateTimeSerializer());
        map.put(Long.class, ToStringSerializer.instance);
        return builder -> builder.serializersByType(map);
    }

    @Bean
    public LocalDateTimeSerializer localDateTimeSerializer() {
        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern));
    }
}
