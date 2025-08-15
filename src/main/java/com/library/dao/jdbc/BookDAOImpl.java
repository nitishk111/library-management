package com.library.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.dao.BookDAO;
import com.library.model.Book;
import com.library.util.query.BookQueryMapper;

public class BookDAOImpl implements BookDAO {

	Connection connection = null;

	public BookDAOImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public int addBook(Book book) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(BookQueryMapper.insertBook);
		pstmt.setString(1, book.getBookTitle());
		pstmt.setString(2, book.getBookAuthor());
		pstmt.setBoolean(3, book.isBookAvailable());
		int columns = pstmt.executeUpdate();
		return columns;
	}

	@Override
	public List<Book> getBooks() throws SQLException {
		List<Book> books = new ArrayList<Book>();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(BookQueryMapper.getBooks);
		while (rs.next()) {
			Book book = new Book();
			book.setBookId(rs.getInt("BOOK_ID"));
			book.setBookTitle(rs.getString("BOOK_TITLE"));
			book.setBookAuthor(rs.getString("BOOK_AUTHOR"));
			book.setBookAvailable(rs.getBoolean("BOOK_AVAILABLE"));
			books.add(book);
		}
		return books;
	}

	@Override
	public Book getBookById(int bookId) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(BookQueryMapper.getBookById);
		pstmt.setInt(1, bookId);
		ResultSet rs = pstmt.executeQuery();
		Book book = new Book();
		if (rs.next()) {
			book.setBookId(rs.getInt("BOOK_ID"));
			book.setBookTitle(rs.getString("BOOK_TITLE"));
			book.setBookAuthor(rs.getString("BOOK_AUTHOR"));
			book.setBookAvailable(rs.getBoolean("BOOK_AVAILABLE"));
		}
		return book;
	}

    @Override
    public List<Book> getBookByAvailability(boolean bookAvailable) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement(BookQueryMapper.getBookByAvailability);
        pstmt.setBoolean(1, bookAvailable);
        ResultSet rs = pstmt.executeQuery();
        List<Book> books= new ArrayList<>();
        while (rs.next()) {
            Book book = new Book();
            book.setBookId(rs.getInt("BOOK_ID"));
            book.setBookTitle(rs.getString("BOOK_TITLE"));
            book.setBookAuthor(rs.getString("BOOK_AUTHOR"));
            book.setBookAvailable(rs.getBoolean("BOOK_AVAILABLE"));
            books.add(book);
        }
        return books;
    }

    @Override
	public List<Book> getBookByTitle(String bookTitle) throws SQLException{
        PreparedStatement pstmt = connection.prepareStatement(BookQueryMapper.getBookByTitle);
        pstmt.setString(1, bookTitle);
        ResultSet rs = pstmt.executeQuery();
        List<Book> books= new ArrayList<>();
        while (rs.next()) {
            Book book = new Book();
            book.setBookId(rs.getInt("BOOK_ID"));
            book.setBookTitle(rs.getString("BOOK_TITLE"));
            book.setBookAuthor(rs.getString("BOOK_AUTHOR"));
            book.setBookAvailable(rs.getBoolean("BOOK_AVAILABLE"));
            books.add(book);
        }
        return books;
	}

	@Override
	public List<Book> getBookByAuthor(String bookAutor) throws SQLException{
        PreparedStatement pstmt = connection.prepareStatement(BookQueryMapper.getBookByAuthor);
        pstmt.setString(1, bookAutor);
        ResultSet rs = pstmt.executeQuery();
        List<Book> books= new ArrayList<>();
        while (rs.next()) {
            Book book = new Book();
            book.setBookId(rs.getInt("BOOK_ID"));
            book.setBookTitle(rs.getString("BOOK_TITLE"));
            book.setBookAuthor(rs.getString("BOOK_AUTHOR"));
            book.setBookAvailable(rs.getBoolean("BOOK_AVAILABLE"));
            books.add(book);
        }
        return books;
	}

    @Override
    public void updateBookAvailability(int bookId, boolean bookAvailable) throws SQLException {
        PreparedStatement pstmt= connection.prepareStatement(BookQueryMapper.updateBookAvailability);

        pstmt.setBoolean(1,bookAvailable);
        pstmt.setInt(2,bookId);

        pstmt.executeUpdate();
    }

    @Override
    public void deleteBookRecord(int bookId) throws SQLException {
        PreparedStatement pstmt= connection.prepareStatement(BookQueryMapper.deleteBookRecord);
        pstmt.setInt(1,bookId);
        pstmt.executeUpdate();
    }

    @Override
	public void createBookTable() throws SQLException {
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(BookQueryMapper.createTable);
	}

	@Override
	public boolean isBookAvailable(String bookTitle, String bookAuthor) throws SQLException{
		PreparedStatement pstmt = connection.prepareStatement(BookQueryMapper.isBookAvailable);
		ResultSet rs= pstmt.executeQuery();
		if(rs.next()) {
			return true;
		}
		return false;
	}

}
