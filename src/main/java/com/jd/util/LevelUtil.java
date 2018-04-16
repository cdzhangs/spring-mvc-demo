package com.jd.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by admin360buyad on 2018/4/6.
 */
public class LevelUtil {

    public static final String SEPARATOR = ".";
    public static final String ROOT = "0";

    public static String calcLevel(String parentLevel, Integer parentId) {

        if (StringUtils.isBlank(parentLevel)) {
            return ROOT;
        } else {
            return StringUtils.join(parentLevel, SEPARATOR, parentId);
        }
    }
}
