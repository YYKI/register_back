package top.yyki.controller;

import com.alibaba.fastjson.JSON;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.yyki.service.DepartmentService;

import java.util.Map;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/getDepartments")
    @ResponseBody
    public String getDepartments() {
        String res = departmentService.getDepartmentsAll();
        return res;
    }

    @RequestMapping("/getDepartmentsCount")
    @ResponseBody
    public int getDepartmentsCount() {
        int res = departmentService.getDepartmentsCount();
        return res;
    }

    @RequestMapping("/addDepartment")
    @ResponseBody
    public int addDepartment(HttpServletRequest request) {
        String params = request.getParameter("department");
        Map<String, Object> department = JSON.parseObject(params);
        departmentService.addDepartment(department);
        return 1;
    }

    @RequestMapping("/deleteDepartment")
    @ResponseBody
    public int deleteDepartment(HttpServletRequest request) {
        String param = request.getParameter("departmentId");
        departmentService.deleteDepartment(Integer.parseInt(param));
        return 1;
    }

    @RequestMapping("/updateDepartment")
    @ResponseBody
    public int updateDepartment(HttpServletRequest request) {
        String departmentName = request.getParameter("departmentName");
        String departmentId = request.getParameter("departmentId");
        departmentService.updateDepartment(departmentName, Integer.parseInt(departmentId));
        return 1;
    }
}
