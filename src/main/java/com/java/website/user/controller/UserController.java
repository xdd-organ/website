package com.java.website.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.java.website.common.vo.Result;
import com.java.website.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author xdd
 * @date 2018/8/21
 */
@RequestMapping("user")
@RestController
@CrossOrigin
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("getUserInfo")//
    public Result getUserInfo(@RequestBody Map<String, Object> params, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object userId = session.getAttribute("userId");
        logger.info("获取用户信息参数：{},userId:{}", JSONObject.toJSONString(params), userId);
        params.put("user_id", userId);
        Map<String, Object> user = userService.getByUserId(userId.toString());
        logger.info("获取用户信息返回：{}", JSONObject.toJSONString(user));
        return new Result(100, user);
    }

    @RequestMapping("getUserByUserId")//
    public Result getUserByUserId(@RequestBody Map<String, Object> params) {
        logger.info("获取用户信息参数：{},userId:{}", JSONObject.toJSONString(params));
        Object userId = params.get("user_id");
        Map<String, Object> user = userService.getByUserId(userId.toString());
        logger.info("获取用户信息返回：{}", JSONObject.toJSONString(user));
        return new Result(100, user);
    }


    @RequestMapping("updateByUserId")//修改用户信息
    public Result updateByUserId(@RequestBody Map<String, Object> params, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object userId = session.getAttribute("userId");
        logger.info("修改用户信息参数：{},userId:{}", JSONObject.toJSONString(params), userId);
        int i = userService.updateByUserId(params);
        logger.info("修改用户信息返回：{}", i);
        return new Result(100);
    }


    @RequestMapping("pageByUser")
    public Result pageByUser(@RequestBody Map<String, Object> params) {
        logger.info("分页查询用户参数：{}", params);
        PageInfo pageInfo = userService.pageByUser(params);
        logger.info("分页查询用户返回：{}", pageInfo);
        return new Result(100, pageInfo);
    }

    @RequestMapping("login")
    public Result login(@RequestBody Map<String, String> params) {
        String username = params.get("username");
        String password = params.get("password");
        logger.info("账号：{}，密码：{}", username, password);
        Map<String, Object> user = userService.getByUsername(username);
        if (user == null) {
            return new Result(500, "用户名或密码错误");
        } else {
            String pwd = String.valueOf(user.remove("password"));
            if (pwd.equalsIgnoreCase(password)) {
                return new Result(100, user);
            } else {
                return new Result(500, "用户名或密码错误");
            }
        }
    }


}
