package com.jd.service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.jd.dao.SysDeptMapper;
import com.jd.dto.SysDeptDto;
import com.jd.model.SysDept;
import com.jd.util.LevelUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by admin360buyad on 2018/4/6.
 */
@Service
public class SysTreeService {

    @Resource
    private SysDeptMapper sysDeptMapper;

    public List<SysDeptDto> deptTree() {

        List<SysDept> sysDeptList = sysDeptMapper.getAllDept();

        List<SysDeptDto> sysDeptDtoList = Lists.newArrayList();

        for (SysDept sysDept : sysDeptList) {
            SysDeptDto dto = SysDeptDto.convert(sysDept);
            sysDeptDtoList.add(dto);
        }

        return toTree(sysDeptDtoList);
    }

    public List<SysDeptDto> toTree(List<SysDeptDto> sysDeptDtoList) {

        if (CollectionUtils.isEmpty(sysDeptDtoList)) {
            return Lists.newArrayList();
        }

        Multimap<String, SysDeptDto> multimap = ArrayListMultimap.create();

        List<SysDeptDto> rootList = Lists.newArrayList();

        for (SysDeptDto sysDeptDto : sysDeptDtoList) {
            multimap.put(sysDeptDto.getLevel(), sysDeptDto);
            if (LevelUtil.ROOT.equals(sysDeptDto.getLevel())) {
                rootList.add(sysDeptDto);
            }
        }

        // 排序
        Collections.sort(rootList, new Comparator<SysDeptDto>() {
            public int compare(SysDeptDto o1, SysDeptDto o2) {
                return o1.getSeq() - o2.getSeq();
            }
        });

        transform(rootList, LevelUtil.ROOT, multimap);
        return rootList;
    }

    public void transform(List<SysDeptDto> dtoList, String level, Multimap<String, SysDeptDto> multimap) {

        for (int i = 0; i < dtoList.size(); i++) {
            // 遍历每层部门
            SysDeptDto dto = dtoList.get(i);
            // 处理当前层级的数据
            String nextLevel = LevelUtil.calcLevel(level, dto.getId());
            // 处理下一层级
            List<SysDeptDto> tempDeptList = (List<SysDeptDto>) multimap.get(nextLevel);

            if (CollectionUtils.isNotEmpty(tempDeptList)) {
                // 排序
                Collections.sort(tempDeptList, deptSeqComparator);
                // 设置下一层部门
                dto.setSubList(tempDeptList);
                // 进入下一层处理
                transform(tempDeptList, nextLevel, multimap);
            }
        }
    }

    public Comparator<SysDeptDto> deptSeqComparator = new Comparator<SysDeptDto>() {
        public int compare(SysDeptDto o1, SysDeptDto o2) {
            return o1.getSeq() - o2.getSeq();
        }
    };
}
