package com.jd.controller;

import com.jd.common.ApplicationContextHelper;
import com.jd.common.JsonData;
import com.jd.dao.SysAclModuleMapper;
import com.jd.exception.ParamException;
import com.jd.model.SysAclModule;
import com.jd.param.TestVo;
import com.jd.util.BeanValidator;
import com.jd.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by admin360buyad on 2018/4/5.
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping("/hello.json")
    public JsonData hello() {
        log.info("hello permission");
        //throw new PermissionException("test exception");
        return JsonData.success("hello permission");
    }


    @GetMapping("/validate.json")
    public JsonData validate(TestVo testVo) {
        log.info("validate");
        try {
            Map<String, String> map = BeanValidator.validateObject(testVo);
            if (MapUtils.isNotEmpty(map)) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    log.info("{}-->{}", entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception e) {
            log.error("error", e);
        }
        return JsonData.success("test validate");
    }


    @GetMapping("/validate2.json")
    public JsonData validate2(TestVo testVo) throws ParamException {
        log.info("validate2");
        BeanValidator.check(testVo);
        return JsonData.success("test validate2 ");
    }

    @GetMapping("/context.json")
    public JsonData context() {
        SysAclModuleMapper moduleMapper = ApplicationContextHelper.popBean(SysAclModuleMapper.class);
        SysAclModule sysAclModule = moduleMapper.selectByPrimaryKey(1);
        log.info(JsonMapper.obj2String(sysAclModule));
        return JsonData.success("test validate2 ");
    }

}
