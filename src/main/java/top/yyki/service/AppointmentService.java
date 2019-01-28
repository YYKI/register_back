package top.yyki.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yyki.dao.AppointmentsDao;

import java.util.List;
import java.util.Map;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentsDao appointmentsDao;

    public String getAppointments(int doctorId) {
        List<Map<String, Object>> appointments = appointmentsDao.getAppointmentsByDoctor(doctorId);
        String res = JSON.toJSONString(appointments);
        return res;

    }

    public String addAppointment(Map<String, Object> appointment) {
        int res = appointmentsDao.addAppointment(appointment);
        if (res > 0) {
            return "ok";
        }
        return "error";
    }

    public String deleteAppointment(int id) {
        int res = appointmentsDao.deleteAppointment(id);
        if (res > 0) {
            return "ok";
        }
        return "error";
    }
}
