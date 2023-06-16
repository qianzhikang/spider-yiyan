package com.qzk.resolve.init;


import com.qzk.resolve.util.DatabaseUtil;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @Description 创建数据库
 * @Date 2023-06-15-13-45
 * @Author qianzhikang
 */
public class InitTable {


    public static void main(String[] args) {

        // 解析json（本地）
        List<Map> maps = DatabaseUtil.resolveJson(FilePath.ANIME.getPath());

        // 解析json （远程）
        //List<Map> maps = DatabaseUtil.resolveJsonHttp(HttpPath.ANIME.getPath());

        List<String> cols = getColumnList(maps);
        // 初始化数据库连接
        SqlSessionFactory sqlSessionFactory = DatabaseUtil.initMysqlConnect();
        //创建表
        createTable(sqlSessionFactory, "tb_sentence", cols);
    }


    /**
     * 解析map中的key作为列
     * @param maps
     * @return
     */
    private static List<String> getColumnList(List<Map> maps) {
        // 获取一个
        Map map = maps.get(0);
        // 表的列名
        List<String> cols = new ArrayList<>();
        // 取key作为列名放到list中
        for (Object o : map.keySet()) {
            String key = String.valueOf(o);
            cols.add(key);
        }
        return cols;
    }



    /**
     * @param sqlSessionFactory sql工厂
     * @param tableName         表名
     * @param cols              列名集合
     */
    private static void createTable(SqlSessionFactory sqlSessionFactory, String tableName, List<String> cols) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 创建SQL语句模版
            StringBuilder createTableSql = new StringBuilder("CREATE TABLE " + tableName + " (id INT PRIMARY KEY");
            // 循环拼接
            for (String col : cols) {
                if ("id".equals(col)) {
                    continue;
                }
                if ("from".equals(col)) {
                    col = "from_arts";
                }
                createTableSql.append(",").append(col).append(" ").append("VARCHAR(255)");
            }
            // 添加结尾
            createTableSql.append(",remark VARCHAR(255))");
            // 执行
            session.getConnection().createStatement().execute(createTableSql.toString());
            // 提交
            session.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
