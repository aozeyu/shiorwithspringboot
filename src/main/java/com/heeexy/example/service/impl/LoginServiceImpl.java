package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.LoginDao;
import com.heeexy.example.service.LoginService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.Session;

/**
 * @program: example
 * @description: 222
 * @packagename: com.heeexy.example.service.impl
 * @author: 姚泽宇
 * @date: 2022-07-14 19:20
 **/
@Service
public class LoginServiceImpl implements LoginService {
    private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Autowired
    private LoginDao loginDao;

    /**
     * 登录表单提交
     *
     * @param jsonObject
     * @return
     */
    @Override
    public JSONObject authLogin(JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        JSONObject returnData = new JSONObject();
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            currentUser.login(token);
            returnData.put("result", "success");
        } catch (AuthenticationException e) {
            returnData.put("result", "fail");
        }

        return CommonUtil.successJson(returnData);
    }

    @Override
    public JSONObject getUser(String username, String password) {
        return loginDao.getUser(username, password);
    }

    /**
     * 查询当前登录用户的权限等信息
     *
     * @return
     */
    @Override
    public JSONObject getInfo() {
        return null;
    }

    /**
     * 退出登录
     *
     * @return
     */
    @Override
    public JSONObject logout() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
        }catch (Exception e) {

        }
        return CommonUtil.successJson();
    }
}
