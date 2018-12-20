package cn.kspshare.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ksp")
public class BaseConstant {
    public String ROLE_USER;
    public String ROLE_ADMIN;

    public String getROLE_USER() {
        return ROLE_USER;
    }

    public void setROLE_USER(String ROLE_USER) {
        this.ROLE_USER = ROLE_USER;
    }

    public String getROLE_ADMIN() {
        return ROLE_ADMIN;
    }

    public void setROLE_ADMIN(String ROLE_ADMIN) {
        this.ROLE_ADMIN = ROLE_ADMIN;
    }
}
