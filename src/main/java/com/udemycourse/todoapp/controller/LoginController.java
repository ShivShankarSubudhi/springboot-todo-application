package com.udemycourse.todoapp.controller;


import com.udemycourse.todoapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showLogin(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String username, @RequestParam String password){
        if(!loginService.isValidUser(username,password)){
            model.put("errorMessage","Invalid Credentials!");
            return "login";
        }
        model.put("username",username);

        return  "welcome";
    }

}
