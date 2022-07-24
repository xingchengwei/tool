package com.xcw.springtool.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonObject {

    private static JSONObject jsonObject=new JSONObject();

    /**
     * 对象转字符串
     *
     * @param object
     * @return
     */
    public static String toJsonString(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * 字符串转对象
     *
     * @param jsonStr
     * @param cla
     * @param <T>
     * @return
     */
    public static <T extends Object> T fromJson(String jsonStr, Class<T> cla) {
        return jsonObject.getObject(jsonStr,cla);
    }


    /**
     * 字符串转集合对象
     *
     * @param jsonStr
     * @param cla
     * @param <T>
     * @return
     */
//    public static <T extends Object> List<T> fromJsonToArray2(String jsonStr, Class<T> cla) {
//        JsonArray jsonArray = JsonParser.parseString(jsonStr).getAsJsonArray();
//        ArrayList<T> tmpList = new ArrayList<>();
//        for (JsonElement jsonObj : jsonArray) {
//            //使用GSON，直接转成Bean对象
//            T obj = gson.fromJson(jsonObj, cla);
//            tmpList.add(obj);
//        }
//        return tmpList;
//    }
}
