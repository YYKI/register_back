package top.yyki.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {

    @Select("select * from user where username= #{username}")
    List<Map<String, String>> getUser(String username);
}
