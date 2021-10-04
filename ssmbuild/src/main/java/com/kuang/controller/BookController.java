package com.kuang.controller;

import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import com.kuang.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author 郭宇航
 * @date 2021/10/3
 * @apiNote
 */
@Controller
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    /**
     * 查询全部的书籍，并返回到一个书籍展示页面
     * @param model
     * @return 
     */
    @GetMapping("/book/allBook")
    public String listBook(Model model) {
        List<Books> list = bookService.queryAllBook();
        for (Books books : list) {
            System.out.println(books);
        }

        model.addAttribute("bookList", list);

        return "allBook";
    }

    /**
     * 跳转addBook.jsp
     * @return
     */
    @GetMapping("/book/toAddBookPiper")
    public String toAddBookPiper() {
        return "addBook";
    }

    /**
     * 跳转addBook
     * @param model
     * @return
     */
    @PostMapping("/book/addBook")
    public String addBook(Books books,Model model) {
        System.out.println(books);
        bookService.addBook(books);

        return "redirect:/book/allBook";
    }

}
