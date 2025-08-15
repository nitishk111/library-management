package com.library.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.library.dao.BookDAO;
import com.library.dao.LoanDAO;
import com.library.dao.MemberDAO;
import com.library.dao.jdbc.BookDAOImpl;
import com.library.dao.jdbc.LoanDAOImpl;
import com.library.dao.jdbc.MemberDAOImpl;
import com.library.model.Loan;
import com.library.model.Member;
import com.library.service.LibraryService;

public class LibraryServiceImpl implements LibraryService {
	
	BookDAO bookDao;
	MemberDAO memberDao;
	LoanDAO loanDao;
	
	public LibraryServiceImpl(Connection connection) {
		bookDao= new BookDAOImpl(connection);
		memberDao= new MemberDAOImpl(connection);
		loanDao = new LoanDAOImpl(connection);
	}


    @Override
    public void createLoanTable() throws SQLException {
    		this.loanDao.createLoanTable();
    }

    @Override
    public String createNewLoan(Loan loan) throws SQLException {
    		List<Loan> loans =this.showAllOutstandingLoan();
    		for(Loan l:loans) {
    			if(l.getBook().getBookId()==loan.getBook().getBookId()) {
    				return "Book is not available to loan";
    			}
    		}
    		this.loanDao.newLoan(loan);
    		this.bookDao.updateBookAvailability(loan.getBook().getBookId(), false);
    		return "Book loaned";
    }

    @Override
    public List<Loan> showAllOutstandingLoan() throws SQLException {
        return this.loanDao.getAllOutstandingLoans();
    }

    @Override
    public List<Loan> showAllLoanRecord() throws SQLException {
        return this.loanDao.getAllLoanRecord();
    }

    @Override
    public Loan showLoanById(int loanId) throws SQLException {
        return this.loanDao.getLoanById(loanId);
    }

    @Override
    public List<Loan> showLoanByMemberId(int memberId) throws SQLException {
        return this.loanDao.getLoanByMemberId(memberId);
    }

    @Override
    public void returnBook(int bookId) throws SQLException {
    		this.loanDao.returnLoan(bookId);
    		bookDao.updateBookAvailability(bookId, true);
    }
}
