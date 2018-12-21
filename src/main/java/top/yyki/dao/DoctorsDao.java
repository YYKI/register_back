package top.yyki.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface DoctorsDao {

    String TABLE = "doctors";
    String COLUMNS = "(name, level, department_id, skill, exp, date)";
    String VALUES = "(#{name}, #{level}, #{departmentId}, #{departmentPid}, #{skill}, #{exp}, #{date})";
    String ORDER = " order by date desc";
    String NOTDELETE = " and delete_flag = 0 ";

    @Select("select * from " + TABLE + " where delete_flag = 0 " + ORDER)
    List<Map<String, Object>> getDoctorsAll();

    @Select("select * from " + TABLE + " where id = #{id} " + NOTDELETE)
    List<Map<String, Object>> getDoctor(int id);

    @Select("select * from " + TABLE + " where name = #{name} " + NOTDELETE + ORDER)
    List<Map<String, Object>> getDoctorsByName(String name);

    @Select("select * from " + TABLE + " where department_id = #{departmentId} " + NOTDELETE + ORDER)
    List<Map<String, Object>> getDoctorsByDepartment(int departmentId);

    @Insert("insert into " + TABLE + COLUMNS + "values " + VALUES)
    int addDoctor(Map<String, Object> doctor);

    @Update("update " + TABLE + " set delete_flag = 1 where id = #{id}")
    int deleteDoctor(int id);

    @Update("update " + TABLE
            + " set level = #{level}, department_id = #{departmentId}, department_pid = #{departmentPid}, exp = #{exp}, skill = #{skill}, date = #{date} "
            + " where id = #{id}")
    int updateDoctor(Map<String, Object> doctor);

    @Select("select count(*) from " + TABLE + " where delete_flag = 0")
    int getdoctorsNum();


}
