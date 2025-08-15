package com.library.model;

import java.time.LocalDate;

public class Loan {

	private int loanId;
	private Book book;
	private Member member;
	private LocalDate loanDate;
	private LocalDate reurnDate;

	public Loan() {
		super();
	}

	public Loan(Book book, Member member) {
		super();
		this.book = book;
		this.member = member;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public LocalDate getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}

	public LocalDate getReurnDate() {
		return reurnDate;
	}

	public void setReurnDate(LocalDate reurnDate) {
		this.reurnDate = reurnDate;
	}

    @Override
	public String toString() {
		return "Loan: loanId=" + loanId + ", book=" + book + ", member=" + member + ", loanDate=" + loanDate
				+ ", reurnDate=" + reurnDate;
	}
	
	
}
