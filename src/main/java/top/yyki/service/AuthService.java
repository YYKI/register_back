package top.yyki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yyki.dao.AuthDao;

import java.time.Instant;
import java.util.*;

@Service
public class AuthService {

    @Autowired
    private AuthDao authDao;

    public String addToken(int userId){
        String token = "AUTH_" + UUID.randomUUID().toString();
        Map<String, Object> auth = new HashMap<>();
        auth.put("userId", userId);
        auth.put("token", token);
        auth.put("date", Instant.now().getEpochSecond());
        authDao.addToken(auth);
        return token;
    }

    public boolean auth(String token){
        int date = (int) (Instant.now().getEpochSecond()-86400);
        List<Map<String, Object>> auth = authDao.getAuth(token, date);
        if( auth == null ||auth.size()==0)
            return false;
        else
            return true;
    }
}
