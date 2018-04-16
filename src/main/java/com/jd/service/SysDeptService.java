package com.jd.service;

import com.jd.dao.SysDeptMapper;
import com.jd.exception.ParamException;
import com.jd.model.SysDept;
import com.jd.param.DeptParam;
import com.jd.util.BeanValidator;
import com.jd.util.LevelUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by admin360buyad on 2018/4/6.
 */
@Service
public class SysDeptService {

    @Resource
    private SysDeptMapper sysDeptMapper;

    public void save(DeptParam param) {

        BeanValidator.check(param);

        if (checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("当前同一层级下存在相同名称的部门");
        }

        SysDept sysDept = SysDept.builder()
                                 .name(param.getName())
                                 .parentId(param.getParentId())
                                 .seq(param.getSeq())
                                 .remark(param.getRemark()).build();

        sysDept.setLevel(LevelUtil.calcLevel(getLevel(param.getParentId()), param.getParentId()));
        sysDept.setOperator("system");
        sysDept.setOperatorIp("127.0.0.1");
        sysDept.setOperatorTime(new Date());

        sysDeptMapper.insertSelective(sysDept);
    }


    private boolean checkExist(Integer parentId, String deptName, Integer deptId) {
        return false;
    }

    private String getLevel(Integer deptId) {
        SysDept sysDept = sysDeptMapper.selectByPrimaryKey(deptId);

        if (sysDept == null) {
            return null;
        }
        return sysDept.getLevel();
    }

}
