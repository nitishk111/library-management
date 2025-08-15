package com.library.dao;

import java.sql.SQLException;
import java.util.List;

import com.library.model.Book;

public interface BookDAO{
	public int addBook(Book book) throws SQLException;
    public void createBookTable() throws SQLException;

    public List<Book> getBooks() throws SQLException;
	public Book getBookById(int bookId) throws SQLException;
    public List<Book> getBookByAvailability(boolean bookAvailable) throws SQLException;
    public List<Book> getBookByTitle(String bookTitle) throws SQLException;
	public List<Book> getBookByAuthor(String bookAutor) throws  SQLException;

    public void updateBookAvailability(int bookId, boolean bookAvailable) throws SQLException;

    public void deleteBookRecord(int bookId) throws SQLException;
	public boolean isBookAvailable(String bookTitle, String bookAuthor) throws SQLException;
}
