package com.young.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Young
 * @create 2021/5/13 16:24
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("msg", "how old are u ?");
        return "hello";
    }

    @RequestMapping("/test/{a}/{b}")
    public String test(@PathVariable int a, @PathVariable int b, Model model) {
        int result = a + b;
        model.addAttribute("msg", "结果为" + result);
        return "hello";
    }
}
