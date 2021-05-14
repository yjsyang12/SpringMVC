package com.young.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Young
 * @create 2021/5/14 11:54
 */
@Controller
public class EncodingController {

    @RequestMapping("/e/t1")
    public String test1(String name, Model model) {

        model.addAttribute("msg", name);

        return "hello";
    }
}
