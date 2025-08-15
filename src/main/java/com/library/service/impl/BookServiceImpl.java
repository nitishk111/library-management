package com.library.service.impl;

import com.library.dao.BookDAO;
import com.library.dao.LoanDAO;
import com.library.dao.jdbc.BookDAOImpl;
import com.library.dao.jdbc.LoanDAOImpl;
import com.library.model.Book;
import com.library.service.BookService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements BookService {

	private BookDAO bookDao;

	public BookServiceImpl(Connection connection) {
		bookDao = new BookDAOImpl(connection);
	}

	@Override
	public void createBookTable() throws SQLException {
		this.bookDao.createBookTable();

	}

	@Override
	public String addBook(Book book) throws SQLException {
		if (bookDao.isBookAvailable(book.getBookTitle(), book.getBookAuthor()))
			return "Book already in Record";
		this.bookDao.addBook(book);
		return "Book Added";

	}

	@Override
	public List<Book> showAllBook() throws SQLException {
		return this.bookDao.getBooks();
	}

	@Override
	public Book showBookById(int bookId) throws SQLException {
		return this.bookDao.getBookById(bookId);
	}

	@Override
	public List<Book> showAvailableBooks() throws SQLException {
		return this.bookDao.getBookByAvailability(true);
	}

	@Override
	public List<Book> showBookByTitle(String bookTitle) throws SQLException {
		return this.bookDao.getBookByTitle(bookTitle);
	}

	@Override
	public List<Book> showBookByAuthor(String bookAuthor) throws SQLException {
		return this.bookDao.getBookByAuthor(bookAuthor);
	}

	@Override
	public String updateBookAvailabilityStatus(int bookId, boolean bookAvailable) throws SQLException {
		List<Book> books = this.bookDao.getBookByAvailability(false);
		for (Book book : books) {
			if (book.getBookId() == bookId)
				return "Book is already lent";
		}
		this.bookDao.updateBookAvailability(bookId, bookAvailable);
		return "Book updated";
	}

	@Override
	public String deleteBookrecord(int bookId) throws SQLException {
		List<Book> books = this.showAvailableBooks();
		for (Book book : books) {
			if (book.getBookId() == bookId) {
				this.bookDao.deleteBookRecord(bookId);
				return "Book record deleted";
			}
		}
		return "Either book is lent or not available in Library";

	}
}
