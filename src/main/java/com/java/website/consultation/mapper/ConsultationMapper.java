package com.java.website.consultation.mapper;

import java.util.List;
import java.util.Map;

/**
 * @author xdd
 * @date 2019/7/26
 */
public interface ConsultationMapper {

    int insert(Map<String, Object> params);

    int update(Map<String, Object> params);

    List<Map<String, Object>> listByConsultation(Map<String, Object> params);
}
