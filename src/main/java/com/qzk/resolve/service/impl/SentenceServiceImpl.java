package com.qzk.resolve.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qzk.resolve.entity.Sentence;
import com.qzk.resolve.service.SentenceService;
import com.qzk.resolve.mapper.SentenceMapper;
import org.springframework.stereotype.Service;

/**
* @author qianzhikang
* @description 针对表【tb_sentence】的数据库操作Service实现
* @createDate 2023-06-15 16:21:20
*/
@Service
public class SentenceServiceImpl extends ServiceImpl<SentenceMapper, Sentence>
    implements SentenceService{

}




