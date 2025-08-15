package com.library.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.Member;
import com.library.service.BookService;
import com.library.service.LibraryService;
import com.library.service.MemberService;
import com.library.service.impl.BookServiceImpl;
import com.library.service.impl.LibraryServiceImpl;
import com.library.service.impl.MemberServiceImpl;
import com.library.util.DBConnection;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.printf("%85s%n","------Library Management------");
		
		Connection connection = DBConnection.creteDbConnection();

		LibraryService libraryService = new LibraryServiceImpl(connection);
        BookService bookService =new BookServiceImpl(connection);
        MemberService memberService= new MemberServiceImpl(connection);

		Book book=new Book("Indian Economics", "Munna Tripathi"); book.setBookId(3);
//		List<Book> books= new ArrayList<Book>();
//
//		List<Member> members= new ArrayList<Member>();
		Member member= new Member("Divyansh","dp@info.com"); member.setMemberId(5);
//
		Loan loan= new Loan(book, member);
		List<Loan> loans= new ArrayList<Loan>();
			
		
		try {
			//System.out.println(libraryService.createNewLoan(loan));
			//libraryService.returnBook(4);
//			loans =libraryService.showAllOutstandingLoan();
			
			//System.out.println(memberService.deleteMemberRecord(4));
			//System.out.println(bookService.deleteBookrecord(1));
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(loan);
		for(Loan l:loans) {
			System.out.println(l);
		}
	}

}
