package com.jd.demo.mapper;

import com.jd.demo.model.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangsong on 2018/4/14 with IntelliJ IDEA.
 */
public interface PersonMapper {

    List<Person> getPersonsByDeptId(@Param("deptId") Integer deptId);

}
