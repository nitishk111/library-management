package com.library.dao;

import java.sql.SQLException;
import java.util.List;

import com.library.model.Book;
import com.library.model.Member;
import com.sun.org.apache.bcel.internal.generic.ATHROW;

public interface MemberDAO {
	public int addMember(Member member) throws SQLException;
    public void createMemberTable() throws SQLException;

	public List<Member> getMembers() throws SQLException;
	public Member getMemberById(int memberId) throws SQLException;
	public Member getMemberByEmail(String memberEmail) throws SQLException;

    public void updateMemberName(int memberId, String memberName) throws SQLException;
    public void updateMemberEmail(int memberId, String memberEmail) throws SQLException;

    public void deleteMemberRecord(int memberId) throws SQLException;
    
    public int noOfLoanOnMemebr(int memberId) throws SQLException;
}
