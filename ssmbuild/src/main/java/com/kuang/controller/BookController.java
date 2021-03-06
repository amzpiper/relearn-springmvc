package com.kuang.controller;

import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import com.kuang.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
     * addBook添加书籍
     * @param model
     * @return
     */
    @PostMapping("/book/addBook")
    public String addBook(Books books,Model model) {
        System.out.println(books);
        bookService.addBook(books);

        return "redirect:/book/allBook";
    }

    /**
     * 跳转updateBook.jsp
     * @return
     */
    @GetMapping("/book/toUpdateBookPiper/{bookId}")
    public String toUpdateBookPiper(@PathVariable("bookId") int id,Model model) {
        Books book = bookService.queryBookById(id);
        model.addAttribute("book", book);
        return "updateBook";
    }

    /**
     * updateBook修改书籍
     *
     * @param model
     * @return
     */
    @PostMapping("/book/updateBook")
    public String updateBook(Books books, Model model) {
        System.out.println("/book/updateBook");
        System.out.println(books);
        bookService.updateBook(books);

        return "redirect:/book/allBook";
    }

    /**
     * deleteBook删除书籍
     *
     * @param model
     * @return
     */
    @GetMapping("/book/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id, Model model) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    /**
     * 查询书籍根据书名
     *
     * @param model
     * @return
     */
    @PostMapping("/book/searchBook")
    public String searchBook(String bookName, Model model) {
        System.out.println(bookName);
        List<Books> bookSearchList = bookService.queryBookByBookName(bookName);
        for (Books books : bookSearchList) {
            System.out.println(books.toString());
        }
        model.addAttribute("bookList", bookSearchList);

        return "allBook";
    }

}
