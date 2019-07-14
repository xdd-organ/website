package com.java.website.product.mapper;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
    int insert(Map<String,Object> params);

    List<Map<String,Object>> listByProduct(Map<String,Object> params);

    int update(Map<String,Object> params);
}
