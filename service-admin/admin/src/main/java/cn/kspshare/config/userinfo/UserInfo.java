package cn.kspshare.config.userinfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 5660946270498221593L;

    private Long oid;
    private String username;
    private String password;
    private String realname;
    private Byte enabled;
    private boolean isAdmin=false;
}
