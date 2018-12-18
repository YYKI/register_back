package top.yyki.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.yyki.model.Doctor;

import java.util.List;
import java.util.Map;

@Mapper
public interface DoctorsDao {

    String TABLE = "doctors";
    String COLUMNS = "(name, level, department_id, skill, exp, date)";
    String VALUES = "(#{name}, #{level}, #{departmentId}, #{skill}, #{exp}, #{date})";
    String ORDER = " order by date desc";

    @Select("select * from " + TABLE + ORDER)
    List<Map<String, Object>> getDoctorsAll();

    @Select("select * from " + TABLE + " where name = #{name}" + ORDER)
    List<Map<String, Object>> getDoctorsByName(String name);

    @Select("select * from " + TABLE + " where department_id = #{departmentId}" + ORDER)
    List<Map<String, Object>> getDoctorsByDepartment(int departmentId);

    @Insert("insert into " + TABLE + COLUMNS + "values " + VALUES)
    int addDoctor(Map<String, Object> doctor);

    @Select("select count(*) from " + TABLE + " where delete_flag = 0")
    int getdoctorsNum();


}
