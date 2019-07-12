package com.tensquare.article.controller;

import com.tensquare.article.pojo.Comment;
import com.tensquare.article.service.CommentService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 文章评论列表
     * @return 文章评论列表
     */
    @GetMapping
    public Result findAll(){
        return new Result(true, StatusCode.OK, "查询成功", commentService.findAll());
    }

    /**
     * 文章评论添加
     * @param comment 文章
     */
    @PostMapping
    public Result saveComment(@RequestBody Comment comment){
        commentService.saveComment(comment);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 根据文章ID查询评论列表
     * @param article 文章ID
     * @return 评论列表
     */
    @GetMapping("/articleid/{article}")
    public Result listComment(@PathVariable String article){
        return new Result(true, StatusCode.OK, "查询成功", commentService.findByArticleid(article));
    }
}
