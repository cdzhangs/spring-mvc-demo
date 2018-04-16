package com.jd.dto;

import com.google.common.collect.Lists;
import com.jd.model.SysDept;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by admin360buyad on 2018/4/6.
 */
@Getter
@Setter
@ToString
public class SysDeptDto extends SysDept {

    private List<SysDeptDto> subList = Lists.newArrayList();

    public static SysDeptDto convert(SysDept sysDept) {
        SysDeptDto dto = new SysDeptDto();
        BeanUtils.copyProperties(sysDept, dto);
        return dto;
    }
}
