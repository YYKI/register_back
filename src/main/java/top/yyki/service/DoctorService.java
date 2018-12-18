package top.yyki.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.yyki.dao.DepartmentDao;
import top.yyki.dao.DoctorsDao;
import top.yyki.model.Doctor;

import java.util.List;
import java.util.Map;

@Service
public class DoctorService {

    @Autowired
    DoctorsDao doctorsDao;
    @Autowired
    DepartmentDao departmentDao;

    public String getDoctors(Map<String, Object> params) {
        String name = (String) params.get("name");
        if (!StringUtils.isEmpty(name)) {
            List<Map<String, Object>> doctors = doctorsDao.getDoctorsByName(name);
            doctorsFilter(doctors);
            String res = JSON.toJSONString(doctors);
            return res;
        }
        String department = (String) params.get("department");
        if (!StringUtils.isEmpty(department)) {
            int departmentId = departmentDao.getDepartmentIdByName(department);
            List<Map<String, Object>> doctors = doctorsDao.getDoctorsByDepartment(departmentId);
            doctorsFilter(doctors);
            String res = JSON.toJSONString(doctors);
            return res;
        }
        List<Map<String, Object>> doctors = doctorsDao.getDoctorsAll();
        doctorsFilter(doctors);
        String res = JSON.toJSONString(doctors);
        return res;

    }

    public void doctorsFilter(List<Map<String, Object>> doctors){
        for(Map<String, Object> doctor : doctors){
            int departmentId = (int) doctor.get("department_id");
            String department = departmentDao.getDepartmentById(departmentId);
            doctor.put("department", department);
        }
    }

    public String addDoctor(Map<String, Object> doctor){
        int res = doctorsDao.addDoctor(doctor);
        if(res>0){
            return "ok";
        }
        return "error";
    }

    public int getDoctorsNum(){
        int num = doctorsDao.getdoctorsNum();
        return num;
    }

}
