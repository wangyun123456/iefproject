package com.ief.storeproject.videoplay.service.impl;

import com.github.pagehelper.PageHelper;
import com.ief.storeproject.videoplay.mapping.BaseMapper;
import com.ief.storeproject.videoplay.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    BaseMapper<T> baseMapper;
    @Override
    public List<T> findAll(Integer pageNum, Integer pageSize, T t) {
        if(pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum,pageSize);
        }
        return baseMapper.selectByExample(t);
    }

    @Override
    public T getById(Integer id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(T t) {
        return baseMapper.insert(t);
    }

    @Override
    public int update(T t) {
        return baseMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Integer id) {
        return baseMapper.deleteByPrimaryKey(id);
    }
}
