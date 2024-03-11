package com.sun.furn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.furn.bean.Furn;
import com.sun.furn.bean.Msg;
import com.sun.furn.service.FurnService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Msg save(@Validated @RequestBody Furn furn, Errors errors) { //将接受到的json字符串转换成Furn对象
        //用来存储错误信息的map
        Map<String, Object> errorMap = new HashMap<>();
        //获取所有的error
        List<FieldError> fieldErrors = errors.getFieldErrors();
            //遍历错误并放到map中
            for (FieldError fieldError : fieldErrors) {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
        //判断map是否为空，为空则表示没有错误
        if (errorMap.isEmpty()) {
            furnService.save(furn);
            return Msg.success();
            //如果没有报错，则返回成功的Msg对象
        } else {
            //将信息放错误的Msg中并返回
            return Msg.fail().add("errMsg", errorMap);
        }

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

    @DeleteMapping("/del/{id}") //路径参数
    @ResponseBody
    public Msg del(@PathVariable Integer id) {
        furnService.del(id);
        return Msg.success();
    }

    @ResponseBody
    @GetMapping("/findById/{id}")
    public Msg findById(@PathVariable Integer id) {
        Furn furn = furnService.findById(id);
        //将查询结果添加到成功的Msg对象中
        return Msg.success().add("furn", furn);
    }

    //分页功能接口
    @RequestMapping("/furnsByPage")
    @ResponseBody
    public Msg listFurnsByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "5") Integer pageSize) {
        //1.设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        //2.查询所有数据
        List<Furn> all = furnService.findAll();
        //3.进行物理分页pageInfo存放了分页的信息
        PageInfo pageInfo = new PageInfo(all, pageSize);

        return Msg.success().add("pageInfo", pageInfo);
    }

    //条件分页接口
    @RequestMapping("/listFurnsByCondition")
    @ResponseBody
    public Msg listFurnsByCondition(@RequestParam(defaultValue = "1") Integer pageNum,
                                    @RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "") String search) {
        //1.设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        //2.查询所有数据
        List<Furn> byCondition = furnService.findByCondition(search);
        //3.进行分页
        PageInfo pageInfo = new PageInfo(byCondition, pageSize);

        return Msg.success().add("pageInfo", pageInfo);
    }

}

































































