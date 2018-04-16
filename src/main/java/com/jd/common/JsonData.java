package com.jd.common;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin360buyad on 2018/4/5.
 */
@Getter
@Setter
public class JsonData<T> {

    private boolean ret;

    private String msg;

    private T data;

    public JsonData(boolean ret) {
        this.ret = ret;
    }

    public static JsonData success(Object data, String msg) {
        JsonData jsonData = new JsonData(true);
        jsonData.data = data;
        jsonData.msg = msg;
        return jsonData;
    }

    public static JsonData success(Object data) {
        JsonData jsonData = new JsonData(true);
        jsonData.data = data;
        return jsonData;
    }

    public static JsonData success() {
        return new JsonData(true);
    }

    public static JsonData fail(String msg) {
        JsonData jsonData = new JsonData(false);
        jsonData.msg = msg;
        return jsonData;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ret", ret);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }
}
