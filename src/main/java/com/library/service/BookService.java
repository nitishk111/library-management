package com.library.service;

import com.library.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookService {

    public void createBookTable() throws SQLException;
    public String addBook(Book book) throws SQLException;

    public List<Book> showAllBook() throws SQLException;
    public Book showBookById(int bookId) throws SQLException;
    public List<Book> showAvailableBooks() throws SQLException;
    public List<Book> showBookByTitle(String bookTitle) throws SQLException;
    public List<Book> showBookByAuthor(String bookAuthor) throws SQLException;

    public String updateBookAvailabilityStatus(int bookId, boolean bookAvailable) throws SQLException;

    public String deleteBookrecord(int bookId) throws SQLException;

}
