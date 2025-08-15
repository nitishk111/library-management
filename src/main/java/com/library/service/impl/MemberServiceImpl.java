package com.library.service.impl;

import com.library.dao.LoanDAO;
import com.library.dao.MemberDAO;
import com.library.dao.jdbc.LoanDAOImpl;
import com.library.dao.jdbc.MemberDAOImpl;
import com.library.model.Loan;
import com.library.model.Member;
import com.library.service.MemberService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDao;

	public MemberServiceImpl(Connection connection) {
		this.memberDao = new MemberDAOImpl(connection);

	}

	@Override
	public void createMemberTable() throws SQLException {
		this.memberDao.createMemberTable();

	}

	@Override
	public void addMember(Member member) throws SQLException {
		this.memberDao.addMember(member);

	}

	@Override
	public List<Member> showAllMember() throws SQLException {
		return this.memberDao.getMembers();
	}

	@Override
	public Member showMemberById(int memberId) throws SQLException {
		return this.memberDao.getMemberById(memberId);
	}

	@Override
	public Member showMemberByEmail(String memberEmail) throws SQLException {
		return this.memberDao.getMemberByEmail(memberEmail);
	}

	@Override
	public void updateMemberName(int memberId, String memberName) throws SQLException {
		this.memberDao.updateMemberName(memberId, memberName);
	}

	@Override
	public void updateMemberExmail(int memberId, String memberEmail) throws SQLException {
		this.memberDao.updateMemberEmail(memberId, memberEmail);
	}

	@Override
	public String deleteMemberRecord(int memberId) throws SQLException {
		// List<Loan> loans= this.loanDao.getAllOutstandingLoans();
//    		if(loans==null || loans.size()==0) {
//    			this.memberDao.deleteMemberRecord(memberId);
//        		return "Member Record deleted";
//    		}
//    		for(Loan loan:loans) {
//    			if(loan.getMember().getMemberId()== memberId)
//    				return "Member has not returned all books";
//    		}
		if (this.memberDao.noOfLoanOnMemebr(memberId) == 0) {
			this.memberDao.deleteMemberRecord(memberId);
			return "Member Record deleted";
		}
		return "Member has not returned loaned books yet";
	}

	@Override
	public int getNoOfLoanOnMember(int memberId) throws SQLException {
		return this.memberDao.noOfLoanOnMemebr(memberId);
	}
}
