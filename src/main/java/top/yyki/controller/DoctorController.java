package top.yyki.controller;

import com.alibaba.fastjson.JSON;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.yyki.service.DoctorService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @RequestMapping("/getDoctors")
    @ResponseBody
    public String getDoctors(HttpServletRequest request){
        String params = request.getParameter("params");
          Map<String, Object> map = JSON.parseObject(params);
        if(map==null)
            map = new HashMap<>();
        String doctors = doctorService.getDoctors(map);
        return doctors;
    }

    @RequestMapping("/getDoctorsNum")
    @ResponseBody
    public int getDoctorsNum(){
        int res = doctorService.getDoctorsNum();
        return res;
    }

    @RequestMapping("/addDoctor")
    @ResponseBody
    public String addDoctors(HttpServletRequest request){
        String params = request.getParameter("doctor");
        Map<String, Object> map = JSON.parseObject(params);
        String res = doctorService.addDoctor(map);
        return res;
    }
}
