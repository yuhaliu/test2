package com.tensquare.article.service;

import com.tensquare.article.dao.CommentDao;
import com.tensquare.article.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.Date;
import java.util.List;

/**
 * 文章评论访问层
 * @author ASL
 */
@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 文章评论列表
     * @return 文章评论列表
     */
    public List<Comment> findAll(){
        return commentDao.findAll();
    }

    /**
     * 根据文章ID查询文章评论
     * @return 文章评论
     */
    public Comment findById(String id){
        return commentDao.findById(id).get();
    }

    /**
     * 文章评论添加
     * @param comment 文章
     */
    public void saveComment(Comment comment){
        comment.set_id(idWorker.nextId() + "");
        comment.setPublishdate(new Date());
        commentDao.save(comment);
    }

    /**
     * 文章评论修改
     * @param comment 文章
     */
    public void updateComment(Comment comment){
        commentDao.save(comment);
    }

    /**
     * 根据文章ID查询评论列表
     * @param articleid 文章ID
     * @return 评论列表
     */
    public List<Comment> findByArticleid(String articleid){
        return commentDao.findByArticleid(articleid);
    }
}
