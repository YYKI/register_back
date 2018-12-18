package top.yyki.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DepartmentDao {

    String TABLE = "department";
    String COLUMNS = "";

    @Select("select department from " + TABLE + " where id = #{departmentId}")
    String getDepartmentById(int departmentId);

    @Select("select id from " + TABLE + " where department = #{department}")
    int getDepartmentIdByName(String department);

    @Select("select * from " + TABLE + " where pid = #{departmentPid}")
    List<Map<String, Object>> getDepartmentByPid(int departmentPid);
}
