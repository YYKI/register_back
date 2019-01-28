package top.yyki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yyki.dao.UserDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    AuthService authService;

    public Map<String, String> isUserValid(String username, String password){
        Map<String, String> res = new HashMap<>();
        res.put("status", "fail");
        List<Map<String, Object>> userList =  userDao.getUser(username);
        if(userList==null||userList.size()==0)
            return res;
        Map<String, Object> user = userList.get(0);
        if(user.get("password").equals(password)){
            int userId = (int) user.get("id");
            String token = authService.addToken(userId);
            res.put("status", "success");
            res.put("token", token);
            return res;
        }
        return res;
    }
}
