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
    private JSONObject resultJSON;

    public CommonJsonException(ErrorEnum errorEnum) {
        this.resultJSON = CommonUtil.errorJson(errorEnum);
    }
 }
