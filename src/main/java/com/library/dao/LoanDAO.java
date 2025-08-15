package com.library.dao;

import java.sql.SQLException;
import java.util.List;

import com.library.model.Book;
import com.library.model.Loan;

public interface LoanDAO {

    public void createLoanTable() throws SQLException;
	public int newLoan(Loan loan) throws SQLException;

    public List<Loan> getAllOutstandingLoans() throws SQLException;
	public List<Loan> getAllLoanRecord() throws SQLException;
	public Loan getLoanById(int loanId) throws SQLException;
	public List<Loan> getLoanByMemberId(int memberId) throws SQLException;
	
	public void returnLoan(int bookId) throws SQLException;
}
