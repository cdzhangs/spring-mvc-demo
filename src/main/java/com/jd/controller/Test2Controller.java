package com.jd.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin360buyad on 2018/4/5.
 */
@Controller
@RequestMapping("/test2")
@Slf4j
public class Test2Controller {

    @GetMapping("/hello.page")
    public ModelAndView hello() {
        return new ModelAndView("dept");
    }



}
