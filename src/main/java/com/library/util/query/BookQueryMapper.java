package com.library.util.query;

public interface BookQueryMapper {

	public String createTable="CREATE TABLE BOOK( BOOK_ID SERIAL PRIMARY KEY , BOOK_TITLE VARCHAR(20) NOT NULL, BOOK_AUTHOR VARCHAR(20) NOT NULL, BOOK_AVAILABLE BOOLEAN DEFAULT TRUE)";
	public String getBooks="SELECT * FROM BOOK WHERE IS_ACTIVE= TRUE";
	public String insertBook="INSERT INTO BOOK(BOOK_TITLE, BOOK_AUTHOR, BOOK_AVAILABLE) VALUES(?,?,?)";
	public String getBookById="SELECT * FROM BOOK WHERE BOOK_ID=? AND IS_ACTIVE= TRUE";
    public String getBookByAvailability="SELECT * FROM BOOK WHERE BOOK_AVAILABLE=? AND IS_ACTIVE= TRUE";
    public String getBookByAuthor="SELECT * FROM BOOK WHERE BOOK_AUTHOR=? AND IS_ACTIVE= TRUE";
    public String getBookByTitle="SELECT * FROM BOOK WHERE BOOK_TITLE=? AND IS_ACTIVE= TRUE";
    
    public String isBookAvailable="SELECT * FROM BOOK WHERE BOOK_TITLE=? AND BOOK_AUTHOR=?";
 
    public String updateBookAvailability="UPDATE BOOK SET BOOK_AVAILABLE=? WHERE BOOK_ID=? AND IS_ACTIVE= TRUE";

    String deleteBookRecord = "UPDATE BOOK SET IS_ACTIVE= FALSE, BOOK_AVAILABLE= FALSE WHERE BOOK_ID=?";
}
