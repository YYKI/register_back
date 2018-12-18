package top.yyki.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.yyki.dao.DepartmentDao;
import top.yyki.dao.DoctorsDao;
import top.yyki.dao.UserDao;

import java.util.Map;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DoctorsDao doctorsDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void contextLoads() {
        List<Map<String, Object>> userList = doctorsDao.getDoctorsByName("王五");
        for (Map<String, Object> user : userList) {
            System.out.println(user.get("name"));
        }
        System.out.println("ddddd");
    }

    @Test
    public void testDepartment() {
        System.out.println(departmentDao.getDepartmentById(2));
        System.out.println("cccccc");
    }

}
