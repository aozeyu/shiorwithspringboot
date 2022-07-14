package com.heeexy.example.config.exception;


import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.ErrorEnum;

/**
 * @program: example
 * @description: 33
 * @packagename: com.heeexy.example.config.exception
 * @author: 姚泽宇
 * @date: 2022-07-14 17:19
 **/
public class CommonJsonException extends RuntimeException{
    private JSONObject resultJson;

    /**
     * 调用时可以在任何代码处直接throws这个Exception,
     * 都会统一被拦截,并封装好json返回给前台
     *
     * @param errorEnum 以错误的ErrorEnum做参数
     */
    public CommonJsonException(ErrorEnum errorEnum) {
        this.resultJson = CommonUtil.errorJson(errorEnum);
    }

    public CommonJsonException(JSONObject resultJson) {
        this.resultJson = resultJson;
    }

    public JSONObject getResultJson() {
        return resultJson;
    }
 }
