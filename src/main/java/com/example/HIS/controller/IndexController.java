package com.example.HIS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
@Controller
public class IndexController {
    @RequestMapping("/")
    public RedirectView  start(Model model, HttpServletResponse response) {
        RedirectView redirectTarget = new RedirectView();
        redirectTarget.setContextRelative(true);
        redirectTarget.setUrl("index");
        return redirectTarget;
    }
    @RequestMapping("index")
    public String index(Model model, HttpServletResponse response) {
        return "index2";
    }
}
