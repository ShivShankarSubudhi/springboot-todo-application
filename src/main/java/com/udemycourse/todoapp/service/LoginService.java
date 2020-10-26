package com.udemycourse.todoapp.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

    public boolean isValidUser(String username,String password){
        return username.equalsIgnoreCase("shiv") && password.equalsIgnoreCase("shiv100");
    }
}
