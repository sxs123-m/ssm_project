package com.sun.furn.service.impl;

import com.sun.furn.bean.Furn;
import com.sun.furn.dao.FurnMapper;
import com.sun.furn.service.FurnService;
import org.springframework.stereotype.Service;

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
}






















