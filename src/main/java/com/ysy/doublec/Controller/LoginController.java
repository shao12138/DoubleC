package com.ysy.doublec.Controller;

import com.alibaba.fastjson.JSON;
import com.ysy.doublec.Mapper.UserDao;
import com.ysy.doublec.Pojo.User;
import com.ysy.doublec.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request, String userInfo) {
        User user = JSON.parseObject(userInfo, User.class);
        String result = "";
        if (user == null) {
            result = "非法操作！！！";
        } else {
            result = loginService.login(user.getUsername(), user.getPassword());
            if (result.equals("success")) {
                //存放Session
                HttpSession session = request.getSession();
                if (session.getAttribute("username") != null) {
                    result = "online";
                }
                session.setAttribute("username", user.getUsername());
            }
        }
        return result;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "/logout.html";
    }
}
