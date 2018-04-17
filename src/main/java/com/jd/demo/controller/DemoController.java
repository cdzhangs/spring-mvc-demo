package com.jd.demo.controller;

import com.jd.demo.model.Dept;
import com.jd.demo.model.Person;
import com.jd.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhangsong on 2018/4/14 with IntelliJ IDEA.
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/hello")
    public String hello() {

        return "hello world";
    }

    @GetMapping("/depts")
    public List<Dept> getAllDept() {
        return demoService.getAllDept();
    }

    @GetMapping("/person/{deptId}")
    public List<Person> personList(@PathVariable("deptId") Integer deptId) {

        return demoService.getPersonsByDeptId(deptId);
    }

    @GetMapping("/update")
    public void testTx() {
        demoService.testTx();
    }
}
