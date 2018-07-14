package com.ief.storeproject.videoplay.mapping;

import java.util.List;

public interface BaseMapper<T> {

    List<T> selectByExample(T t);

    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
