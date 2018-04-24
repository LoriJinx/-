package com.system.mapper;

import com.system.po.Score;
import com.system.po.ScoreDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ScoreMapper {

    @Select("select u.name as teacher_name, ts.score, ts.semester from users u, teacher_score ts where ts.teacher=#{teaId} and u.uid=#{teaId} and ts.student=#{stuId} and semester=#{semester}")
    ScoreDTO selectByTeacher(@Param("teaId") int teaId, @Param("stuId") int stuId, @Param("semester") String semester);


    @Insert("insert into teacher_score(teacher,student,score,semester) values(#{score.teacher},#{score.student},#{score.score},#{score.semester})")
    Integer insert(@Param("score") Score socre);
}
