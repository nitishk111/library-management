package com.library.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.library.dao.LoanDAO;

import com.library.model.Loan;

import com.library.service.BookService;

import com.library.service.MemberService;
import com.library.service.impl.BookServiceImpl;

import com.library.service.impl.MemberServiceImpl;
import com.library.util.query.LoanQueryMapper;

public class LoanDAOImpl implements LoanDAO {

	Connection connection;
	BookService bookService;
	MemberService memberService;

	public LoanDAOImpl(Connection connection) {
		this.connection = connection;
		bookService = new BookServiceImpl(connection);
		memberService = new MemberServiceImpl(connection);
	}

	@Override
	public int newLoan(Loan loan) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(LoanQueryMapper.newLoan);
		pstmt.setInt(1, loan.getBook().getBookId());
		pstmt.setInt(2, loan.getMember().getMemberId());
		int columns = pstmt.executeUpdate();
		return columns;
	}

	@Override
	public List<Loan> getAllOutstandingLoans() throws SQLException {
		Statement stmt= connection.createStatement();
		ResultSet rs= stmt.executeQuery(LoanQueryMapper.getOutStandingLoans);

		List<Loan> loans= new ArrayList<Loan>();
		while(rs.next()) {
			Loan loan= new Loan();
			loan.setLoanId(rs.getInt("LOAN_ID"));
			loan.setBook(bookService.showBookById(rs.getInt("BOOK_ID")));
			loan.setMember(memberService.showMemberById(rs.getInt("Member_ID")));
			loan.setLoanDate(rs.getObject("LOAN_Date", LocalDate.class));
			loan.setReurnDate(rs.getObject("RETURN_DATE", LocalDate.class));
			loans.add(loan);
		}
		return loans;
	}

	@Override
	public List<Loan> getAllLoanRecord() throws SQLException {
		BookService bookService = new BookServiceImpl(connection);
        MemberService memberService= new MemberServiceImpl(connection);

		List<Loan> loans = new ArrayList<Loan>();
		Statement stmt = connection.createStatement();

		ResultSet rs = stmt.executeQuery(LoanQueryMapper.getAllRecords);
		while (rs.next()) {
			Loan loan = new Loan();
			loan.setLoanId(rs.getInt("LOAN_ID"));
			loan.setBook(bookService.showBookById(rs.getInt("BOOK_ID")));
			loan.setMember(memberService.showMemberById(rs.getInt("Member_ID")));
			loan.setLoanDate(rs.getObject("LOAN_Date", LocalDate.class));
			loan.setReurnDate(rs.getObject("RETURN_DATE", LocalDate.class));
			loans.add(loan);
		}
		return loans;
	}

	@Override
	public Loan getLoanById(int loanId) throws SQLException {
        BookService bookService = new BookServiceImpl(connection);
        MemberService memberService= new MemberServiceImpl(connection);

        PreparedStatement pstmt = connection.prepareStatement(LoanQueryMapper.getLoanById);
		pstmt.setInt(1, loanId);

		ResultSet rs = pstmt.executeQuery();
		Loan loan = new Loan();
		if (rs.next()) {
			loan.setLoanId(rs.getInt("LOAN_ID"));
			loan.setBook(bookService.showBookById(rs.getInt("BOOK_ID")));
			loan.setMember(memberService.showMemberById(rs.getInt("Member_ID")));
			loan.setLoanDate(rs.getObject("LOAN_Date", LocalDate.class));
			loan.setReurnDate(rs.getObject("RETURN_DATE", LocalDate.class));
		}
		return loan;
	}

	@Override
	public List<Loan> getLoanByMemberId(int memberId) throws SQLException {
        BookService bookService = new BookServiceImpl(connection);
        MemberService memberService= new MemberServiceImpl(connection);

        PreparedStatement pstmt = connection.prepareStatement(LoanQueryMapper.getLoanByMember);
		pstmt.setInt(1, memberId);

		ResultSet rs = pstmt.executeQuery();
		List<Loan> loans = new ArrayList<>();
		while(rs.next()) {
			Loan loan = new Loan();
			loan.setLoanId(rs.getInt("LOAN_ID"));
			loan.setBook(bookService.showBookById(rs.getInt("BOOK_ID")));
			loan.setMember(memberService.showMemberById(rs.getInt("Member_ID")));
			loan.setLoanDate(rs.getObject("LOAN_Date", LocalDate.class));
			loan.setReurnDate(rs.getObject("RETURN_DATE", LocalDate.class));
			loans.add(loan);
		}
		return loans;
	}

    @Override
    public void returnLoan(int bookId) throws SQLException {
    		PreparedStatement pstmt = connection.prepareStatement(LoanQueryMapper.returnBook);
    		pstmt.setDate(1, Date.valueOf(LocalDate.now()));
    		pstmt.setInt(2, bookId);
    		pstmt.executeUpdate();
    }

    @Override
	public void createLoanTable() throws SQLException {
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(LoanQueryMapper.createTable);

	}

}
