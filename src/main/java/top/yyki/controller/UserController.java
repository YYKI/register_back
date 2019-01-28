package top.yyki.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.yyki.service.AuthService;
import top.yyki.service.UserService;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    AuthService authService;

    @RequestMapping("/get")
    @ResponseBody
    public String demoData(){
        String as = "hello world";
        return as;
    }

    @RequestMapping("/verify")
    @ResponseBody
    public Map<String, String> verify(@RequestParam String username, @RequestParam String password){
        Map<String, String> res = userService.isUserValid(username, password);
        return res;
    }
}
