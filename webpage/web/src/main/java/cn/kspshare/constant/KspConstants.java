package cn.kspshare.constant;

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
    public String ROLE_USER;
    public String ROLE_ADMIN;
    public String siteName;
    public String siteHost;
}
