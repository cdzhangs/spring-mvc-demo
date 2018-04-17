package com.jd.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by zhangsong on 2017/8/9.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = -640649318748812610L;

    private Integer id;

    private String name;

    private Integer deptId;
}
