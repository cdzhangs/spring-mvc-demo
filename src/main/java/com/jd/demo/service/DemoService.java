package com.jd.demo.service;

import com.jd.demo.model.Dept;
import com.jd.demo.model.Person;

import java.util.List;

/**
 * Created by zhangsong on 2018/4/14 with IntelliJ IDEA.
 */
public interface DemoService {

    List<Dept> getAllDept();

    List<Person> getPersonsByDeptId(Integer deptId);

    void testTx();
}
