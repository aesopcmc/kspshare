package cn.kspshare.domain;

import lombok.*;

/**
 * 论坛评论关系表
 * bbs_parent_child
 * 
 * @author Mybatis Generator
 */
@Getter
@Setter
public class BbsParentChild {
    /**
     * 主键
     * oid
     */
    private Long oid;

    /**
     * 父评论ID
     * parent_context_id
     */
    private Long parentContextId;

    /**
     * 子评论ID
     * child_context_id
     */
    private Long childContextId;
}