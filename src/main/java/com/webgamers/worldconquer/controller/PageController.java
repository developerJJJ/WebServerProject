package com.webgamers.worldconquer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping()
    public String index() {
        return "index";
    }

    @GetMapping("main")
    public String main() {
        return "main";
    }

    @GetMapping("register")
    public String register() {
        return "register";
    }
}
