package top.yyki.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface AuthDao {
    String TABLE = "auth";
    String COLUMNS = "(user_id, token, date)";
    String VALUES = "(#{userId}, #{token}, #{date})";

    @Insert("insert into " + TABLE + COLUMNS + "values " + VALUES)
    int addToken(Map<String, Object> auth);

    @Select("select * from " + TABLE + " where token = #{token} and date > #{date} ")
    List<Map<String, Object>> getAuth(@Param("token") String token, @Param("date") int date);
}
