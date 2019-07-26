package com.java.website.consultation.controller;

import com.github.pagehelper.PageInfo;
import com.java.website.common.vo.Result;
import com.java.website.consultation.service.ConsultationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author xdd
 * @date 2019/7/26
 */
@CrossOrigin
@RestController
@RequestMapping("consultation")
public class ConsultationController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultationController.class);

    @Autowired
    private ConsultationService consultationService;


    @RequestMapping("insert")
    public Result insert(@RequestBody Map<String, Object> params) {
        LOGGER.info("保存咨询参数：{}", params);
        Map<String, Object> res = consultationService.insert(params);
        LOGGER.info("保存咨询返回：{}", res);
        return new Result(100, res);
    }

    @RequestMapping("update")
    public Result update(@RequestBody Map<String, Object> params) {
        LOGGER.info("更新咨询参数：{}", params);
        int res = consultationService.update(params);
        LOGGER.info("更新咨询返回：{}", res);
        return new Result(100, res);
    }

    @RequestMapping("pageByConsultation")
    public Result pageByProduct(@RequestBody Map<String, Object> params) {
        LOGGER.info("分页查询咨询参数：{}", params);
        PageInfo res = consultationService.pageByConsultation(params);
        LOGGER.info("分页查询咨询返回：{}", res);
        return new Result(100, res);
    }

    @RequestMapping("listByConsultation")
    public Result listByProduct(@RequestBody Map<String, Object> params) {
        LOGGER.info("条件查询咨询参数：{}", params);
        List<Map<String,Object>> res = consultationService.listByConsultation(params);
        LOGGER.info("条件查询咨询返回：{}", res);
        return new Result(100, res);
    }
}
