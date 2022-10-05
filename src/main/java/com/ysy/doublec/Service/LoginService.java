package com.ysy.doublec.Service;

import com.ysy.doublec.Mapper.UserDao;
import com.ysy.doublec.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginService {
    @Autowired
    UserDao userDao;
    public String login(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            return "none";
        } else if (!password.equals(user.getPassword())) {
            return "fail";
        } else {
            return "success";
        }
    }
}
