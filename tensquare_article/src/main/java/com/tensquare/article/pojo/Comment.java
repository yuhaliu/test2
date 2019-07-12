package com.tensquare.article.pojo;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章评论(mongoDB)
 * @author ASL
 */
@Data
public class Comment implements Serializable {

    @Id
    private String _id; // ID
    private String articleid; // 文章ID
    private String content; // 评论内容
    private String userid; // 评论人ID
    private String parentid; // 评论ID 如果为0表示文章的顶级评论
    private Date publishdate; // 评论日期
}
