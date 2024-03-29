package com.java.website.common.service.impl;

import com.java.website.common.mapper.FileMapper;
import com.java.website.common.service.FileService;
import com.java.website.common.utils.DateUtil;
import com.java.website.common.utils.SerialNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xdd
 * @date 2018/7/26
 */
@Service
public class FileServiceImpl implements FileService {

    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Value("${imgPath:img}")
    private String imgPath;
    @Value("${imgBaseUrl:http://120.79.240.245:8086/website/static/}")
    private String imgBaseUrl;

    @Autowired
    private FileMapper fileMapper;

    @Value("${savePath:/app/website/static/}")
    private String savePath;

    @Override
    public List<Map<String, Object>> upload(MultipartFile[] files) {
        List<Map<String, Object>> params = null;
        try {
            params = new ArrayList<>();
            for (MultipartFile file : files) {
                String fileName = file.getOriginalFilename();
                long size = file.getSize()/1000; //KB
                String suffix = fileName.substring(fileName.lastIndexOf("."));
                String filePath = savePath + imgPath + File.separator + DateUtil.getDateyyyyMMdd();
                File saveFile = new File(filePath);
                if (!saveFile.exists()) saveFile.mkdirs();
                String date = DateUtil.getDateyyyyMMddHHmmssSSSS() + suffix;
                filePath = filePath + File.separator + date;
                FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(filePath));

                Map<String, Object> param = new HashMap<>();
                String imgBasePath = DateUtil.getDateyyyyMMdd()+ "/" + date;
                param.put("name", imgBasePath);
                param.put("file_name", fileName);
                param.put("size", size);
                param.put("url", imgBaseUrl + imgPath + "/" + imgBasePath);
                param.put("key", SerialNumber.getRandomNum());
                params.add(param);
            }
            logger.info("上传文件入库参数：{}", params);
            int ret = fileMapper.upload(params);
            logger.info(ret +"");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        logger.info("上传文件返回：{}", params);
        return params;
    }

    @Override
    public Map<String, Object> download(String key) {
        logger.info("下载文件参数：{}", key);
        Map<String, Object> file = fileMapper.getByKey(key);
        String filePath = savePath + imgPath + File.separator + String.valueOf(file.get("name"));
        file.put("filePath", filePath);
        logger.info("下载文件返回：{}", file);
        return file;
    }
}
