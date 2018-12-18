package top.yyki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.yyki.service.DepartmentService;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/getDepartments")
    @ResponseBody
    public String getDepartments(){
        String res = departmentService.getDepartmentsAll();
        return res;
    }
}
