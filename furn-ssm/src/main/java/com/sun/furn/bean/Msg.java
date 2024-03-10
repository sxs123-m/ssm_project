package com.sun.furn.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据到前端的通用类
 * @author 孙显圣
 * @version 1.0
 */
public class Msg {
    //状态码
    private int code;
    //成功或失败的信息
    private String msg;
    //要返回的信息（一个map就是一个json对象）
    private Map<String, Object> extend = new HashMap<>();

    //静态方法，获取成功的Msg对象
    public static Msg success() {
        Msg success = new Msg();
        //设置状态码和成功的信息
        success.setMsg("success");
        success.setCode(200);
        return success;
    }

    //静态方法，获取失败的Msg对象
    public static Msg fail() {
        Msg fail = new Msg();
        fail.setCode(400);
        fail.setMsg("fail");
        return fail;
    }

    //添加要返回的信息到Msg,并且返回这个对象
    public Msg add(String key, Object value) {
        extend.put(key, value);
        //在使用这个add之前一定是要有一个这个Msg类型的对象
        //当这个对象调用这个实例方法时，为这个对象的属性添加一个值，然后直接返回this就是当前对象
        return this;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
