package com.sun.furn.service.impl;

import com.github.pagehelper.util.StringUtil;
import com.sun.furn.bean.Furn;
import com.sun.furn.bean.FurnExample;
import com.sun.furn.dao.FurnMapper;
import com.sun.furn.service.FurnService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 孙显圣
 * @version 1.0
 */
@Service
public class FurnServiceImpl implements FurnService {
    //注入一个FurnMapper的代理对象
    @Resource
    private FurnMapper furnMapper;
    @Override
    public void save(Furn furn) {
        furnMapper.insertSelective(furn);
    }

    @Override
    public List<Furn> findAll() {
        //传入的是null就代表返回所有信息
        return furnMapper.selectByExample(null);
    }

    @Override
    public void update(Furn furn) {
        furnMapper.updateByPrimaryKeySelective(furn);
    }

    @Override
    public void del(Integer id) {
        furnMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Furn findById(Integer id) {
        Furn furn = furnMapper.selectByPrimaryKey(id);
        return furn;
    }

    @Override
    public List<Furn> findByCondition(String name) {
        FurnExample furnExample = new FurnExample();
        //使用这个对象来添加条件
        FurnExample.Criteria criteria = furnExample.createCriteria();
        //判断是否有查询条件
        if (StringUtils.hasText(name)) {
            //添加根据传进来的名字进行模糊查询
            criteria.andNameLike("%" + name + "%");
        }
        //进行查询
        //注意：这里如果是没有传参数，则会查询出所有的记录
        return furnMapper.selectByExample(furnExample);
    }
}
























