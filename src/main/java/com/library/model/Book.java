package com.library.model;

public class Book {
	
	private int bookId;
	private String bookTitle;
	private String bookAuthor;
	private boolean bookAvailable;
    private  boolean isActive;
	
	public Book() {
		
	}

	public Book(String bookTitle, String bookAuthor) {
		super();
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookAvailable=true;
        this.isActive=true;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public boolean isBookAvailable() {
		return bookAvailable;
	}

	public void setBookAvailable(boolean bookAvailable) {
		this.bookAvailable = bookAvailable;
	}

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    @Override
	public String toString() {
		return "Book: bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", bookAvailable="
				+ bookAvailable;
	}
	

}
