package com.ysy.doublec.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RequestController {
    @RequestMapping("/")
    public String index() {

        return "forward:login.html";
    }
}
