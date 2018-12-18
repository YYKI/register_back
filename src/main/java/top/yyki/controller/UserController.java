package top.yyki.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.yyki.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/get")
    @ResponseBody
    public String demoData(){
        String as = "hello world";
        return as;
    }

    @RequestMapping("/verify")
    @ResponseBody
    public String verify(@RequestParam String username, @RequestParam String password){
        boolean valid = userService.isUserValid(username, password);
        if(valid){
            return "success";
        }
        return "fail";
    }
}
