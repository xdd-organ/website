package com.java.website.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.website.product.mapper.ProductMapper;
import com.java.website.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Map<String, Object> insert(Map<String, Object> params) {
        productMapper.insert(params);
        return params;
    }

    @Override
    public PageInfo pageByProduct(Map<String, Object> params) {
        PageHelper.startPage(Integer.valueOf(params.get("pageNum").toString()), Integer.valueOf(params.get("pageSize").toString()));
        return new PageInfo(productMapper.listByProduct(params));
    }

    @Override
    public int update(Map<String, Object> params) {
        return productMapper.update(params);
    }

    @Override
    public List<Map<String,Object>> listByProduct(Map<String, Object> params) {
        return productMapper.listByProduct(params);
    }
}
