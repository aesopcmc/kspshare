package cn.kspshare.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.*;

/**
 * 论坛版块表
 * bbs_session
 * 
 * @author Mybatis Generator
 */
@Getter
@Setter
public class BbsSession {
    /**
     * 主键
     * oid
     */
    private Long oid;

    /**
     * 板块名称
     * name
     */
    private String name;

    /**
     * 板块主题、简要
     * profile
     */
    private String profile;

    /**
     * 总发帖数
     * topic_count
     */
    private Integer topicCount;

    /**
     * 总浏览量
     * view_count
     */
    private Integer viewCount;

    /**
     * 总点击率
     * click_rate
     */
    private Float clickRate;

    /**
     * 排序
     * sort
     */
    private Integer sort;

    /**
     * 创建时间
     * create_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 创建人ID
     * create_user
     */
    private Long createUser;

    /**
     * 创建时间
     * update_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 更新人ID
     * update_user
     */
    private Long updateUser;
}