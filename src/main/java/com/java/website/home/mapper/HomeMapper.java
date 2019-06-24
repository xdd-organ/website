package com.java.website.home.mapper;

import java.util.List;
import java.util.Map;

/**
 * @author xdd
 * @date 2019/6/24
 */
public interface HomeMapper {

    int insert(Map<String, Object> params);

    List<Map<String, Object>> getHome();
}
