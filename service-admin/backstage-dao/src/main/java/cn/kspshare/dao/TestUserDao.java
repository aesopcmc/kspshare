package cn.kspshare.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TestUserDao{

    @Select("<script>" +
            "select * from test_user u left join test_grade g on u.grade_id=g.tid " +
            "where 1=1 " +
            "<if test=\"age!=null\">" +
            "   AND u.age=#{age} " +
            "</if>" +
            "<if test=\"userName!=null and userName!=''\">" +
            "   AND u.userName like CONCAT('%',#{userName},'%') " +
            "</if>" +
            "<if test=\"level!=null\"> " +
            "   AND g.level=#{level} " +
            "</if>" +
            "</script>")
    List<Map<String, Object>> findUserAndGradeGreaterAge(@Param("age") Integer age,
                                                         @Param("userName") String userName,
                                                         @Param("level") Integer level);
}
