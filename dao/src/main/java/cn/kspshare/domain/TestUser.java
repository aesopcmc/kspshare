package cn.kspshare.domain;

import javax.persistence.*;

@Table(name = "test_user")
public class TestUser {
    /**
     * 主键
     */
    @Id
    private Long tid;

    @Column(name = "user_name")
    private String userName;

    private Integer age;

    /**
     * 1
            2
            3
     */
    @Column(name = "grade_id")
    private Long gradeId;

    /**
     * 获取主键
     *
     * @return tid - 主键
     */
    public Long getTid() {
        return tid;
    }

    /**
     * 设置主键
     *
     * @param tid 主键
     */
    public void setTid(Long tid) {
        this.tid = tid;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取1
            2
            3
     *
     * @return grade_id - 1
            2
            3
     */
    public Long getGradeId() {
        return gradeId;
    }

    /**
     * 设置1
            2
            3
     *
     * @param gradeId 1
            2
            3
     */
    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }
}