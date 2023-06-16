package com.qzk.resolve.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tb_sentence
 */
@TableName(value ="tb_sentence")
@Data
public class Sentence implements Serializable {
    /**
     * 
     */
    @TableId(value = "id")
    private Integer id;

    /**
     * 
     */
    @TableField(value = "hitokoto")
    private String hitokoto;

    /**
     * 
     */
    @TableField(value = "creator")
    private String creator;

    /**
     * 
     */
    @TableField(value = "commit_from")
    private String commitFrom;

    /**
     * 
     */
    @TableField(value = "length")
    private String length;

    /**
     * 
     */
    @TableField(value = "created_at")
    private String createdAt;

    /**
     * 
     */
    @TableField(value = "from_arts")
    private String fromArts;

    /**
     * 
     */
    @TableField(value = "creator_uid")
    private String creatorUid;

    /**
     * 
     */
    @TableField(value = "reviewer")
    private String reviewer;

    /**
     * 
     */
    @TableField(value = "type")
    private String type;

    /**
     * 
     */
    @TableField(value = "uuid")
    private String uuid;

    /**
     * 
     */
    @TableField(value = "remark")
    private String remark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}