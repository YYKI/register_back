package top.yyki.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface DepartmentDao {

    String TABLE = "department";
    String COLUMNS = " (id, pid, department)";
    String VALUES = " (#{id}, #{pid}, #{department}) ";

    @Select("select department from " + TABLE + " where id = #{departmentId}")
    String getDepartmentById(int departmentId);

    @Select("select id from " + TABLE + " where department = #{department}")
    int getDepartmentIdByName(String department);

    @Select("select * from " + TABLE + " where pid = #{departmentPid}")
    List<Map<String, Object>> getDepartmentByPid(int departmentPid);

    @Select("select count(*) from " + TABLE)
    int getDepartmentsCount();

    @Insert("insert into " + TABLE + COLUMNS + "values " + VALUES)
    int addDepartment(Map<String, Object> department);

    @Delete("delete from " + TABLE + " where id = #{id}")
    int deleteDepartment(int id);

    @Update("update " + TABLE + " set department = #{department} where id = #{id}")
    int updateDepartment(@Param("department") String department, @Param("id") int id);
}
