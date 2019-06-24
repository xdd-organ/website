package com.java.website.home.controller;

import com.java.website.home.mapper.HomeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author xdd
 * @date 2019/6/24
 */
@RestController
@CrossOrigin
@RequestMapping("home")
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private HomeMapper homeMapper;

    @RequestMapping("home")
    public String home() {
        LOGGER.info("HomeController.home");
        return "home";
    }

    @RequestMapping("index")
    public Object index() {
        LOGGER.info("HomeController.index");
        List<Map<String, Object>> home = homeMapper.getHome();
        return home;
    }
}
