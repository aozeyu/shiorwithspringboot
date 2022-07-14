package com.heeexy.example.util;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @program: example
 * @description: 222
 * @packagename: com.heeexy.example.util
 * @author: 姚泽宇
 * @date: 2022-07-14 17:38
 **/
public class CommonUtil {

    public static JSONObject successJson() {
        return successJson(new JSONObject());
    }

    public static JSONObject successJson(Object returnData) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("returnCode", Constants.SUCCESS_CODE);
        resultJson.put("returnMsg", Constants.SUCCESS_MSG);
        resultJson.put("returnData", returnData);
        return resultJson;
    }

    public static JSONObject errorJson(ErrorEnum errorEnum) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("returnCode", errorEnum.getErrorCode());
        resultJson.put("returnMsg", errorEnum.getErrorMsg());
        resultJson.put("returnData", new JSONObject());
        return resultJson;
    }

    public static JSONObject successPage(final JSONObject requestJson, List<JSONObject> list, int totalCount) {
        int pageRow = requestJson.getIntValue("pageRow");
        int totalPage = getPageCounts(pageRow, totalCount);
        JSONObject result = successJson();
        JSONObject returnData = new JSONObject();
        returnData.put("list", list);
        returnData.put("totalCount", totalCount);
        returnData.put("totalPage", totalPage);
        result.put("returnData", returnData);
        return result;
    }

    public static int getPageCounts(int pageRow, int itemCount) {
        if (itemCount == 0) {
            return 1;
        }
        return itemCount % pageRow > 0 ?
                itemCount / pageRow + 1 :
                itemCount / pageRow;
    }

    /**
     * 查询分页结果后的封装工具方法
     *
     * @param list 查询分页对象list
     */
    public static JSONObject successPage(List<JSONObject> list) {
        JSONObject result = successJson();
        JSONObject returnData = new JSONObject();
        returnData.put("list", list);
        result.put("returnData", returnData);
        return result;
    }

}
