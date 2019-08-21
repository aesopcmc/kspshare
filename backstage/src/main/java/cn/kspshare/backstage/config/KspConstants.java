package cn.kspshare.backstage.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 自定义常量配置
 */
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "ksp")
public class KspConstants {
    public Integer jwtExpiredSecend;
}
