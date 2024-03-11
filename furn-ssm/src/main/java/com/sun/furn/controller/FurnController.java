package com.sun.furn.controller;

import com.sun.furn.bean.Furn;
import com.sun.furn.bean.Msg;
import com.sun.furn.service.FurnService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 孙显圣
 * @version 1.0
 */

@Controller //单例bean注入容器
public class FurnController {
    @Resource //依赖注入，指向针对FurnService接口的代理对象
    private FurnService furnService;

    @ResponseBody //将结果转换成json字符串返回
    @PostMapping("/save")
    public Msg save(@RequestBody Furn furn) { //将接受到的json字符串转换成Furn对象
        furnService.save(furn);
        //如果没有报错，则返回成功的Msg对象
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping("/furns")
    public Msg listFurns() {
        //从后端获取所有信息
        List<Furn> all = furnService.findAll();
        //封装成功的Msg并返回
        return Msg.success().add("furnList", all);
    }

    @ResponseBody
    @RequestMapping("/update")
    public Msg update(@RequestBody  Furn furn) {
        //更新数据
        furnService.update(furn);
        //如果没有异常则返回成功信息
        return Msg.success();
    }




}



















