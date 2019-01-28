package top.yyki.controller;

import com.alibaba.fastjson.JSON;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.yyki.service.AppointmentService;
import java.util.Map;

@Controller
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @RequestMapping("/getAppointments")
    @ResponseBody
    public String getAppointments(HttpServletRequest request) {
        String id = request.getParameter("doctorId");
        String res = appointmentService.getAppointments(Integer.parseInt(id));
        return res;
    }

    @RequestMapping("/addAppointment")
    @ResponseBody
    public String addDoctors(HttpServletRequest request) {
        String params = request.getParameter("appointment");
        Map<String, Object> map = JSON.parseObject(params);
        String res = appointmentService.addAppointment(map);
        return res;
    }


    @RequestMapping("/deleteAppointment")
    @ResponseBody
    public String deleteDoctors(HttpServletRequest request) {
        String id = request.getParameter("appointmentId");
        String res = appointmentService.deleteAppointment(Integer.parseInt(id));
        return res;
    }
}
