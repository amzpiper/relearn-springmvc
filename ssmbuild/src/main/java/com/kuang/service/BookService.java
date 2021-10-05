package com.kuang.service;

import com.kuang.pojo.Books;
import java.util.List;

/**
 * @author 郭宇航
 * @date 2021/10/3
 * @apiNote
 */
public interface BookService {

    /**
     * 增加一本书
     *
     * @param books
     * @return
     */
    int addBook(Books books);

    /**
     * 删除一本书
     *
     * @param id
     * @return
     */
    int deleteBookById(int id);

    /**
     * 更新一本书
     *
     * @param books
     * @return
     */
    int updateBook(Books books);

    /**
     * 查询一本书id
     *
     * @param id
     * @return
     */
    Books queryBookById(int id);

    /**
     * 查询一本书name
     *
     * @param bookName
     * @return
     */
    List<Books> queryBookByBookName(String bookName);

    /**
     * 查询所有书
     *
     * @return
     */
    List<Books> queryAllBook();
}
