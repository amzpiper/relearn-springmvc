package com.kuang.pojo;

import java.util.Objects;

/**
 * @author 郭宇航
 * @date 2021/10/3
 * @apiNote
 */
public class Books {

    private int bookId;
    private String bookName;
    private String bookCounts;
    private String detail;

    public Books() {
    }

    public Books(int bookId, String bookName, String bookCounts, String detail) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookCounts = bookCounts;
        this.detail = detail;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookCounts() {
        return bookCounts;
    }

    public void setBookCounts(String bookCounts) {
        this.bookCounts = bookCounts;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookCounts='" + bookCounts + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return bookId == books.bookId &&
                Objects.equals(bookName, books.bookName) &&
                Objects.equals(bookCounts, books.bookCounts) &&
                Objects.equals(detail, books.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, bookName, bookCounts, detail);
    }
}
