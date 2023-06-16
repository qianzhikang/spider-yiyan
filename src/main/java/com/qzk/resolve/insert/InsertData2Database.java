package com.qzk.resolve.insert;

import cn.hutool.core.bean.BeanUtil;
import com.qzk.resolve.entity.Sentence;
import com.qzk.resolve.init.FilePath;
import com.qzk.resolve.init.HttpPath;
import com.qzk.resolve.mapper.SentenceMapper;
import com.qzk.resolve.service.SentenceService;
import com.qzk.resolve.util.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description 插入数据
 * @Date 2023-06-15-16-05
 * @Author qianzhikang
 */
public class InsertData2Database {

    public static void main(String[] args) {
        // 本地文件
        //List<Sentence> sentences = dataProcessing(DatabaseUtil.resolveJson(FilePath.ANIME.getPath()),FilePath.ANIME.getComment());
        //List<Sentence> comic = dataProcessing(DatabaseUtil.resolveJsonHttp(FilePath.COMIC.getPath()),FilePath.COMIC.getComment());
        //List<Sentence> game = dataProcessing(DatabaseUtil.resolveJsonHttp(FilePath.GAME.getPath()),FilePath.GAME.getComment());
        //List<Sentence> literature = dataProcessing(DatabaseUtil.resolveJsonHttp(FilePath.LITERATURE.getPath()),FilePath.LITERATURE.getComment());
        //List<Sentence> origin = dataProcessing(DatabaseUtil.resolveJsonHttp(FilePath.ORIGIN.getPath()),FilePath.ORIGIN.getComment());
        //List<Sentence> internet = dataProcessing(DatabaseUtil.resolveJsonHttp(FilePath.INTERNET.getPath()),FilePath.INTERNET.getComment());
        //List<Sentence> other = dataProcessing(DatabaseUtil.resolveJsonHttp(FilePath.OTHER.getPath()),FilePath.OTHER.getComment());
        //List<Sentence> movie = dataProcessing(DatabaseUtil.resolveJsonHttp(FilePath.MOVIE.getPath()),FilePath.MOVIE.getComment());
        //List<Sentence> poem = dataProcessing(DatabaseUtil.resolveJsonHttp(FilePath.POEM.getPath()),FilePath.POEM.getComment());
        //List<Sentence> netease = dataProcessing(DatabaseUtil.resolveJsonHttp(FilePath.NETEASE.getPath()),FilePath.NETEASE.getComment());
        //List<Sentence> philosophy = dataProcessing(DatabaseUtil.resolveJsonHttp(FilePath.PHILOSOPHY.getPath()),FilePath.PHILOSOPHY.getComment());

        // github爬取
        List<Sentence> anime = dataProcessing(DatabaseUtil.resolveJsonHttp(HttpPath.ANIME.getPath()),HttpPath.ANIME.getComment());
        List<Sentence> comic = dataProcessing(DatabaseUtil.resolveJsonHttp(HttpPath.COMIC.getPath()),HttpPath.COMIC.getComment());
        List<Sentence> game = dataProcessing(DatabaseUtil.resolveJsonHttp(HttpPath.GAME.getPath()),HttpPath.GAME.getComment());
        List<Sentence> literature = dataProcessing(DatabaseUtil.resolveJsonHttp(HttpPath.LITERATURE.getPath()),HttpPath.LITERATURE.getComment());
        List<Sentence> origin = dataProcessing(DatabaseUtil.resolveJsonHttp(HttpPath.ORIGIN.getPath()),HttpPath.ORIGIN.getComment());
        List<Sentence> internet = dataProcessing(DatabaseUtil.resolveJsonHttp(HttpPath.INTERNET.getPath()),HttpPath.INTERNET.getComment());
        List<Sentence> other = dataProcessing(DatabaseUtil.resolveJsonHttp(HttpPath.OTHER.getPath()),HttpPath.OTHER.getComment());
        List<Sentence> movie = dataProcessing(DatabaseUtil.resolveJsonHttp(HttpPath.MOVIE.getPath()),HttpPath.MOVIE.getComment());
        List<Sentence> poem = dataProcessing(DatabaseUtil.resolveJsonHttp(HttpPath.POEM.getPath()),HttpPath.POEM.getComment());
        List<Sentence> netease = dataProcessing(DatabaseUtil.resolveJsonHttp(HttpPath.NETEASE.getPath()),HttpPath.NETEASE.getComment());
        List<Sentence> philosophy = dataProcessing(DatabaseUtil.resolveJsonHttp(HttpPath.PHILOSOPHY.getPath()),HttpPath.PHILOSOPHY.getComment());


        // 插入数据库
        insertData(anime);
        insertData(comic);
        insertData(game);
        insertData(literature);
        insertData(origin);
        insertData(internet);
        insertData(other);
        insertData(movie);
        insertData(poem);
        insertData(netease);
        insertData(philosophy);


    }


    private static List<Sentence> dataProcessing(List<Map> source,String comment) {
        // 将map都转换为Sentence
        List<Sentence> sentences = source.stream().map(item ->
        {
            Sentence sentence = BeanUtil.fillBeanWithMap(item, new Sentence(), true);
            // 处理因为数据库中关键字占用的from而修改的字段名称
            sentence.setFromArts(String.valueOf(item.get("from")));
            sentence.setRemark(comment);
            return sentence;
        }).collect(Collectors.toList());

        return sentences;
    }


    private static void insertData(List<Sentence> sentences) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtil.initMysqlConnect();

        // 使用SqlSessionFactory创建SqlSession
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 获取Mapper接口的实例
            SentenceMapper sentenceMapper = session.getMapper(SentenceMapper.class);
            // 调用Mapper方法进行数据库操作
            sentenceMapper.insertAll(sentences);
            // 提交
            session.commit();
        }
    }
}
