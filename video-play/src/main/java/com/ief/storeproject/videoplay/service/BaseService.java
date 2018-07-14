package com.ief.storeproject.videoplay.service;

import java.util.List;

public interface BaseService<T> {

    List<T> findAll(Integer pageNum, Integer pageSize, T t);

    T getById(Integer id);

    int insert(T t);

    int update(T t);

    int delete(Integer id);

}
