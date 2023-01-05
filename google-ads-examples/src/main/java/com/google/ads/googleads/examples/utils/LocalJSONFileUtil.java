package com.google.ads.googleads.examples.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class LocalJSONFileUtil {
    /*
       * 根据key获取json
     * @param filepath 文件路径
     * @param key json的key
     * @return
             */
    public  Object getJSONByKey(String filepath, String key){
        String text =  LocalJSONFileUtil.getFileText(filepath);
        JSONObject object = new JSONObject();
        if (StringUtils.isNoneBlank(text)){
            object = parseObject(text);
        }
        return object.get(key);
    }

    /**
     * 将json 字符串转换为json对象
     */
    public static JSONObject parseObject(String text) {
        return JSONObject.parseObject(text);
    }

    /**
     * 将json 字符串转换为json对象
     */
    public static JSONArray parseArray(String text) {
        return JSONArray.parseArray(text);
    }


    /**
     * 获取文件内文本
     * @param filepath
     * @return
     */
    public static String getFileText(String filepath){
        StringBuffer sb = new StringBuffer();
        try{
            InputStream in = LocalJSONFileUtil.class.getResourceAsStream(filepath);
            if(in==null){
                throw new FileNotFoundException("Resource not found: "+filepath);
            }
            Reader reader = new InputStreamReader(in);
            int ch = 0;
            while ((ch = reader.read())!=-1){
                sb.append((char)ch);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString().replaceAll("\r\n","");
    }
}
