package com.udemycourse.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("error")
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleExecption(HttpServletRequest request,Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception",ex.getStackTrace());
        mv.addObject("url",request.getRequestURL());
        mv.setViewName("error");
        return mv;
    }

}
