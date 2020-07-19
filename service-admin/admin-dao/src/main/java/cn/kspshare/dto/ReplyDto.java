package cn.kspshare.dto;

import lombok.Data;

@Data
public class ReplyDto {
    /**
     * 评论、回复id
     */
    private Long contextId;
    /**
     * 作者名称
     */
    private String authorName;
    /**
     * 评论、回复内容
     */
    private String context;
    /**
     * 更新人
     */
    private Long updateUser;
}
