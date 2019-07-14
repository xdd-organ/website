package com.java.website.product.controller;

import com.github.pagehelper.PageInfo;
import com.java.website.common.vo.Result;
import com.java.website.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("product")
@CrossOrigin
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping("insert")
    public Result insert(@RequestBody Map<String, Object> params) {
        LOGGER.info("保存产品参数：{}", params);
        Map<String, Object> res = productService.insert(params);
        LOGGER.info("保存产品返回：{}", res);
        return new Result(100, res);
    }

    @RequestMapping("update")
    public Result update(@RequestBody Map<String, Object> params) {
        LOGGER.info("更新产品参数：{}", params);
        int res = productService.update(params);
        LOGGER.info("更新产品返回：{}", res);
        return new Result(100, res);
    }

    @RequestMapping("pageByProduct")
    public Result pageByProduct(@RequestBody Map<String, Object> params) {
        LOGGER.info("分页查询产品参数：{}", params);
        PageInfo res = productService.pageByProduct(params);
        LOGGER.info("分页查询产品返回：{}", res);
        return new Result(100, res);
    }

    @RequestMapping("listByProduct")
    public Result listByProduct(@RequestBody Map<String, Object> params) {
        LOGGER.info("条件查询产品参数：{}", params);
        List<Map<String,Object>> res = productService.listByProduct(params);
        LOGGER.info("条件查询产品返回：{}", res);
        return new Result(100, res);
    }

}
