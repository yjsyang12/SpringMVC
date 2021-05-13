package com.young.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Young
 * @create 2021/5/13 14:17
 */
public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg","HelloSpringMVC!");
        modelAndView.setViewName("hello"); // "/WEB-INF/jsp/hello.jsp"
        return modelAndView;
    }
}
