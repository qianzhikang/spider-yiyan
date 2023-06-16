package com.qzk.resolve.mapper;

import com.qzk.resolve.entity.Sentence;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author qianzhikang
* @description 针对表【tb_sentence】的数据库操作Mapper
* @createDate 2023-06-15 16:21:20
* @Entity com.qzk.resolve.entity.Sentence
*/
@Mapper
public interface SentenceMapper extends BaseMapper<Sentence> {
    /**
     * 批量插入
     * @param sentences 数据
     * @return 影响行数
     */
    void insertAll(List<Sentence> sentences);
}




