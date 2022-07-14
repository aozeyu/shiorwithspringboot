package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @program: example
 * @description: 333
 * @packagename: com.heeexy.example.service
 * @author: 姚泽宇
 * @date: 2022-07-14 19:13
 **/
public interface LoginService {
    /**
     * 登录表单提交
     *
     * @param jsonObject
     * @return
     */
    JSONObject authLogin(JSONObject jsonObject);
    JSONObject getUser(String username,String password);
    /**
     * 查询当前登录用户的权限等信息
     *
     * @return
     */
    JSONObject getInfo();

    /**
     * 退出登录
     *
     * @return
     */
    JSONObject logout();
}
