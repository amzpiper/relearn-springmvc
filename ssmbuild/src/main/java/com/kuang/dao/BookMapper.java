package com.kuang.dao;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 郭宇航
 * @date 2021/10/3
 * @apiNote
 */
public interface BookMapper {

    /**
     * 增加一本书
     * @param books
     * @return
     */
    int addBook(Books books);

    /**
     * 删除一本书
     * @param id
     * @return
     */
    int deleteBookById(@Param("bookId") int id);

    /**
     * 更新一本书
     * @param books
     * @return
     */
    int updateBook(Books books);

    /**
     * 查询一本书
     * @param id
     * @return
     */
    Books queryBookById(@Param("bookId")int id);

    /**
     * 查询所有书
     * @return
     */
    List<Books> queryAllBook();

}
