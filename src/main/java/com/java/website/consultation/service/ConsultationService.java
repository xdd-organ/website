package com.java.website.consultation.service;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map; /**
 * @author xdd
 * @date 2019/7/26
 */
public interface ConsultationService {
    Map<String,Object> insert(Map<String, Object> params);

    int update(Map<String, Object> params);

    PageInfo pageByConsultation(Map<String, Object> params);

    List<Map<String,Object>> listByConsultation(Map<String, Object> params);
}
