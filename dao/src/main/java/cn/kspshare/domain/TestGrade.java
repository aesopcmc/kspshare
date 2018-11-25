package cn.kspshare.domain;

import javax.persistence.*;

@Table(name = "test_grade")
public class TestGrade {
    @Id
    private Long tid;

    @Column(name = "grade_name")
    private String gradeName;

    @Column(name = "grade_code")
    private String gradeCode;

    private Integer level;

    /**
     * @return tid
     */
    public Long getTid() {
        return tid;
    }

    /**
     * @param tid
     */
    public void setTid(Long tid) {
        this.tid = tid;
    }

    /**
     * @return grade_name
     */
    public String getGradeName() {
        return gradeName;
    }

    /**
     * @param gradeName
     */
    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    /**
     * @return grade_code
     */
    public String getGradeCode() {
        return gradeCode;
    }

    /**
     * @param gradeCode
     */
    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    /**
     * @return level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }
}