package com.tensquare.article.dao;

import com.tensquare.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 文章评论数据访问层
 * @author ASL
 */
public interface CommentDao extends MongoRepository<Comment, String> {

    /**
     * 根据文章ID查询评论列表
     * @param articleid 文章ID
     * @return 评论列表
     */
    List<Comment> findByArticleid(String articleid);
}
