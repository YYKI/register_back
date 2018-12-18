package top.yyki.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yyki.dao.DepartmentDao;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public String getDepartmentsAll(){
        List<Map<String, Object>> departments = departmentDao.getDepartmentByPid(0);
        for(Map<String, Object> department : departments){
            int departmentId = (int) department.get("id");
            List<Map<String, Object>> secondDepartments = departmentDao.getDepartmentByPid(departmentId);
            department.put("children", secondDepartments);
        }
        String res = JSON.toJSONString(departments);
        return res;
    }
}
