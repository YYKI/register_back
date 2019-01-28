package top.yyki.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface AppointmentsDao {

    String TABLE = "appointments";
    String COLUMNS = "(doctor_id, date, count, detail)";
    String VALUES = "(#{doctorId}, #{date}, #{count}, #{detail})";
    String ORDER = " order by date desc";
    String NOTDELETE = " and delete_flag = 0 ";

    @Select("select * from " + TABLE + "  where doctor_id = #{doctorId}" + NOTDELETE + ORDER)
    List<Map<String, Object>> getAppointmentsByDoctor(int doctorId);

    @Insert("insert into " + TABLE + COLUMNS + " values " + VALUES)
    int addAppointment(Map<String, Object> appointment);

    @Update("update " + TABLE + " set delete_flag = 1 where id = #{id}")
    int deleteAppointment(int id);
}
