package com.library.util.query;

public interface LoanQueryMapper {
	
	public String createTable="CREATE TABLE LOAN( LOAN_ID SERIAL PRIMARY KEY , BOOK_ID INT NOT NULL,"
			+ " MEMBER_ID INT NOT NULL, LOAN_DATE DATE DEFAULT CURRENT_DATE, RETURN_DATE DATE,"
			+ " FOREIGN KEY(BOOK_ID) REFERENCES BOOK (BOOK_ID),"
			+ " FOREIGN KEY(MEMBER_ID) REFERENCES MEMBER (MEMBER_ID))";
	public String getAllRecords="SELECT * FROM LOAN";
	public String newLoan="INSERT INTO Loan(BOOK_ID, MEMBER_ID) VALUES(?,?)";
	public String getLoanById="SELECT * FROM LOAN WHERE LOAN_ID=?";
	public String getLoanByMember="SELECT * FROM LOAN WHERE MEMBER_ID=?";
	
	public String getOutStandingLoans= "SELECT * FROM LOAN WHERE RETURN_DATE IS NULL";
	
	public String returnBook="update loan set return_date=? where book_id=?";
}
