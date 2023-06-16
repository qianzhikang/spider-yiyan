package com.qzk.resolve.util;

import cn.hutool.core.io.IoUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * @Description 数据库工具
 * @Date 2023-06-15-16-12
 * @Author qianzhikang
 */
public class DatabaseUtil {
    /**
     * 获取 mybatis 的xml配置流
     *
     * @return
     */
    public static SqlSessionFactory initMysqlConnect() {
        // 加载MyBatis配置文件
        String mybatisConfigPath = "mybatis-config.xml";
        InputStream configInputStream = null;
        try {
            configInputStream = Resources.getResourceAsStream(mybatisConfigPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new SqlSessionFactoryBuilder().build(configInputStream);
    }

    /**
     * 解析json文件
     *
     * @param filePath json文件路径
     */
    public static List<Map> resolveJson(String filePath) {
        try {
            // 获取文件流
            InputStream inputStream = Files.newInputStream(Paths.get(filePath));
            // 读取文件流字符串
            String jsonStr = IoUtil.read(inputStream, StandardCharsets.UTF_8);
            // 解析JSON数据
            JSONArray jsonArray = JSONUtil.parseArray(jsonStr);
            List<Map> dataList = jsonArray.toList(Map.class);
            return dataList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 从github直接爬取
     */
    public static List<Map> resolveJsonHttp(String httpPath) {
        try {
            // 请求
            String jsonStr = HttpUtil.get(httpPath);
            // 解析JSON数据
            JSONArray jsonArray = JSONUtil.parseArray(jsonStr);
            List<Map> dataList = jsonArray.toList(Map.class);
            return dataList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
