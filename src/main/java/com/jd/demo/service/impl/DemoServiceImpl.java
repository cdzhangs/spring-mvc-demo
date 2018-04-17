package com.jd.demo.service.impl;

import com.jd.demo.mapper.DeptMapper;
import com.jd.demo.mapper.PersonMapper;
import com.jd.demo.model.Dept;
import com.jd.demo.model.Person;
import com.jd.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhangsong on 2018/4/14 with IntelliJ IDEA.
 */
@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<Dept> getAllDept() {
        return deptMapper.getAllDept();
    }

    @Override
    public List<Person> getPersonsByDeptId(Integer deptId) {
        return personMapper.getPersonsByDeptId(deptId);
    }

    @Override
    @Transactional
    public void testTx() {
        deptMapper.updateOne();
        deptMapper.updateTwo();
    }
}
