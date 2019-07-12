package com.tensquare.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.article.pojo.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author ASL
 *
 */
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article>{

    /**
     * 文章审核
     * @param id 文章编号
     */
    @Modifying
    @Query(value = "UPDATE tb_article SET state='1' WHERE id=?", nativeQuery = true)
    void updateState(String id);

    /**
     * 点赞
     * @param id 文章编号
     */
    @Modifying
    @Query(value = "UPDATE tb_article SET thumbup=thumbup+1 WHERE id=?", nativeQuery = true)
    void updateThumbup(String id);
}
