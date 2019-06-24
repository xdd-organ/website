package com.java.website.home.controller;

import com.java.website.common.utils.DateUtil;
import com.java.website.common.utils.SerialNumber;
import com.java.website.home.mapper.HomeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Value("${name}")
    private String name;

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

    private String[] lockNos = new String[]{"768901008108","687020003393","686124219814","687020005539","768901008573","687020007063",
            "687020006941","687020002312","768901008343","686123675719","768901007222","768901008518","768901008572","768901008190",
            "768901007222","768901008190","768901008108","768901006742","768901008234","687020010513","768901006767","768901008350"
    };
    private String[] userIds = new String[]{"100000016","100000017","100000018","100000019","100000020","100000021","100000022",
            "100000023","100000024","100000025","100000203","100000204","100000205","100000206","100000207","100000208",
            "100000209","100000210"
    };
    @RequestMapping("insert")
    public Object insert(@RequestParam("date") String date) {
        LOGGER.info("HomeController.insert");
        for (int i = 0; i < 80; i++) {
            int totalTime = new Random().nextInt(21600) + 3600;
            String startTime = calcStartTime(date);
            String endTime = calcEndTime(startTime, totalTime);
            int fee = (int) Math.ceil(totalTime / 3600.0);

            Map<String, Object> params = new HashMap<>();
            params.put("order_no", getRandomNum(32, startTime));
            params.put("user_id", userIds[new Random().nextInt(userIds.length)]);
            params.put("lock_no", lockNos[new Random().nextInt(lockNos.length)]);
            params.put("total_time", totalTime);
            params.put("start_time", startTime);
            params.put("end_time", endTime);
            params.put("fee", "-" + fee * 300);
            params.put("update_time", "2019-06-06 06:06:06");

            homeMapper.insert(params);
        }
        return "success";
    }

    private String calcStartTime(String date) {
        String startTime = null;
        date = date + " " + (new Random().nextInt(20) + 1) + ":"
                + (new Random().nextInt(50) + 1) + ":"
                + (new Random().nextInt(50) + 1);
        startTime = date;
        return startTime;
    }

    public String getRandomNum(int length, String date) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(DateUtil.parseToDate(date)))
                    .append(SerialNumber.generateRandomSerial(length - sb.length()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private String calcEndTime(String date, int date2) {
        String endTime = null;
        try {
            Date date1 = DateUtil.parseToDate(date);
            long time = date1.getTime();
            long l = time + (date2 * 1000);
            Date date3 = new Date(l);
            endTime = DateUtil.getDateForPattern("yyyy-MM-dd HH:mm:ss", date3);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return endTime;
    }

}
