package cn.kspshare.vo;

import cn.kspshare.domain.BbsContext;
import lombok.Data;

@Data
public class ContentVO extends BbsContext {
    /**
     * 作者昵称
     */
    private String authorNickname;
    /**
     * 账号名称
     */
    private String authorUsername;
    /**
     * 作者头像
     */
    private String authorAvatar;
    /**
     * 性别 '0保密 1男 2女，默认0'
     */
    private Byte authorGender;
}
