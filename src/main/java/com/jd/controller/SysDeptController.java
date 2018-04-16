package com.jd.controller;

import com.jd.common.JsonData;
import com.jd.dto.SysDeptDto;
import com.jd.param.DeptParam;
import com.jd.service.SysDeptService;
import com.jd.service.SysTreeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by admin360buyad on 2018/4/6.
 */
@Controller
@RequestMapping("/sys/dept")
@Slf4j
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private SysTreeService sysTreeService;

    @GetMapping("/save.json")
    @ResponseBody
    public JsonData save(DeptParam deptParam) {
        sysDeptService.save(deptParam);
        return JsonData.success();
    }

    @GetMapping("/tree.json")
    @ResponseBody
    public JsonData tree() {
        List<SysDeptDto> list = sysTreeService.deptTree();
        return JsonData.success(list);
    }


}
