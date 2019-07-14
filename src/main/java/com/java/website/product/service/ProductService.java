package com.java.website.product.service;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface ProductService {
    Map<String,Object> insert(Map<String,Object> params);

    PageInfo pageByProduct(Map<String,Object> params);

    int update(Map<String,Object> params);

    List<Map<String,Object>> listByProduct(Map<String,Object> params);
}
