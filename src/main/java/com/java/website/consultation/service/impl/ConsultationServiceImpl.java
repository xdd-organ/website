package com.java.website.consultation.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.website.consultation.mapper.ConsultationMapper;
import com.java.website.consultation.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xdd
 * @date 2019/7/26
 */
@Service
public class ConsultationServiceImpl implements ConsultationService {

    @Autowired
    private ConsultationMapper consultationMapper;

    @Override
    public Map<String, Object> insert(Map<String, Object> params) {
        consultationMapper.insert(params);
        return params;
    }

    @Override
    public int update(Map<String, Object> params) {
        return consultationMapper.update(params);
    }

    @Override
    public PageInfo pageByConsultation(Map<String, Object> params) {
        PageHelper.startPage(Integer.valueOf(params.get("pageNum").toString()), Integer.valueOf(params.get("pageSize").toString()));
        return new PageInfo(consultationMapper.listByConsultation(params));
    }

    @Override
    public List<Map<String, Object>> listByConsultation(Map<String, Object> params) {
        return consultationMapper.listByConsultation(params);
    }
}
