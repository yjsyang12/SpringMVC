package com.young.controller;

import com.young.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Young
 * @create 2021/5/14 10:32
 */
@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/test1")
    public String test1(@RequestParam("username") String name, Model model) {

        System.out.println("接收到前端的参数:" + name);

        model.addAttribute("msg", name);

        return "hello";
    }

    @GetMapping("/test2")
    public String test2(User user){
        System.out.println("接收到前端的参数:" + user.toString());

        return "hello";
    }
}
