package top.yyki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yyki.dao.UserDao;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public boolean isUserValid(String username, String password){
        List<Map<String, String>> userList =  userDao.getUser(username);
        if(userList==null||userList.size()==0)
            return false;
        Map<String, String> user = userList.get(0);
        if(user.get("password").equals(password))
            return true;
        return false;
    }
}
