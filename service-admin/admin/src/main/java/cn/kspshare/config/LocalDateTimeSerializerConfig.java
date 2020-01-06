package cn.kspshare.config;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Spring Boot 提供了 spring.jackson.date-format配置可以让我们进行日期格式化，
 * 但它只能格式化 java.util.Date。
 *
 * 定义一个配置类，在配置类注入两个 Bean 实现日期全局格式化，同时还兼顾了 Date 和 LocalDateTime 并存。
 *
 * 需要配置
 * spring:
 *   jackson:
 *     date-format: yyyy-MM-dd HH:mm:ss
 *     time-zone: GMT+8
 */
@Configuration
public class LocalDateTimeSerializerConfig {
    @Value("${spring.jackson.date-format}")
    private String pattern;

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> builder.serializerByType(LocalDateTime.class, localDateTimeSerializer());
    }

    @Bean
    public LocalDateTimeSerializer localDateTimeSerializer() {
        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern));
    }
}
