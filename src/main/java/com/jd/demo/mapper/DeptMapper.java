package com.jd.demo.mapper;

import com.jd.demo.model.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangsong on 2018/4/14 with IntelliJ IDEA.
 */
@Repository
@Mapper
public interface DeptMapper {

    List<Dept> getAllDept();

    void updateOne();

    void updateTwo();
}
