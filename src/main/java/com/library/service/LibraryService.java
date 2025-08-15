package com.library.service;

import java.sql.SQLException;
import java.util.List;

import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.Member;

public interface LibraryService {

    public void createLoanTable() throws SQLException;
    public String createNewLoan(Loan loan) throws SQLException;

    public List<Loan> showAllOutstandingLoan() throws SQLException;
    public List<Loan> showAllLoanRecord() throws SQLException;
    public Loan showLoanById(int loanId) throws SQLException;
    public List<Loan> showLoanByMemberId(int memberId) throws SQLException;

    public void returnBook(int bookId) throws SQLException;

}
