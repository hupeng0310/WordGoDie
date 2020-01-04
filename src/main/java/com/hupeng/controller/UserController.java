package com.hupeng.controller;

import com.hupeng.entity.User;
import com.hupeng.service.imp.UserServiceImp;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.*;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImp userService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response) {
        JSONObject json = new JSONObject();
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        User user = new User();
        user.setEmail(account);
        user.setAccount(account);
        user.setPassword(password);
        System.out.println(user.toString());
        int loginStatue = userService.userLogin(user);
        switch (loginStatue) {
            case UserServiceImp.SUCCESS:
                HttpSession session = request.getSession();
                session.setAttribute("account",user.getAccount());
                session.setMaxInactiveInterval(3600*6);
                Cookie cookie = new Cookie("account",user.getAccount());
                cookie.setMaxAge(3600*24*7);
                cookie.setPath("/");
                response.addCookie(cookie);
                json.put("loginStatue","success");
                break;
            case UserServiceImp.PASSWORD_ERROR:
                json.put("loginStatue","passwordError");
                break;
            case UserServiceImp.ACCOUNT_NOT_FOUND:
                json.put("loginStatue","accountNotFound");
                break;
        }
        return json.toString();
    }
    @RequestMapping("/register")
    @ResponseBody
    public String register(String email,String account,String password){
        JSONObject json = new JSONObject();
        User user = new User();
        user.setEmail(email);
        user.setAccount(account);
        user.setPassword(password);
        int registerStatue = userService.userRegister(user);
        switch (registerStatue) {
            case UserServiceImp.EMAIL_REGISTERED:
                json.put("registerStatue","emailRegistered");
                break;
            case UserServiceImp.ACCOUNT_REGISTERED:
                json.put("registerStatue","accountRegistered");
                break;
            case UserServiceImp.SUCCESS:
                json.put("registerStatue","success");
                break;
            case UserServiceImp.FAILED:
                json.put("registerStatue","failed");
                break;
        }
        return json.toString();
    }

    @RequestMapping("logout")
    public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("account");
        Cookie cookie = new Cookie("account",null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }
}
