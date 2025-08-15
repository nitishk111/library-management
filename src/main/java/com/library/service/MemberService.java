package com.library.service;

import com.library.model.Member;

import java.sql.SQLException;
import java.util.List;

public interface MemberService {

    public void createMemberTable() throws SQLException;
    public void addMember(Member member) throws SQLException;

    public List<Member> showAllMember() throws SQLException;
    public Member showMemberById(int memberId) throws SQLException;
    public Member showMemberByEmail(String memberemail) throws SQLException;

    public void updateMemberName(int memberId, String memberName) throws SQLException;
    public void  updateMemberExmail(int memberId, String memberEmail) throws SQLException;

    public String deleteMemberRecord(int memberId) throws SQLException;
    
    public int getNoOfLoanOnMember(int memberId) throws SQLException;
}
