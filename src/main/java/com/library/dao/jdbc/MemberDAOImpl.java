package com.library.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.dao.MemberDAO;
import com.library.model.Book;
import com.library.model.Member;
import com.library.util.query.BookQueryMapper;
import com.library.util.query.MemberQueryMapper;

public class MemberDAOImpl implements MemberDAO {

	Connection connection = null;

	public MemberDAOImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public int addMember(Member member) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(MemberQueryMapper.insertmember);
		pstmt.setString(1, member.getMemberName());
		pstmt.setString(2, member.getMemberEmail());
		// pstmt.setDate(3, member.getJoinDate()); default todays date
		int columns = pstmt.executeUpdate();
		return columns;
	}

	@Override
	public List<Member> getMembers() throws SQLException {
		List<Member> members = new ArrayList<Member>();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(MemberQueryMapper.getmembers);
		while (rs.next()) {
			Member member = new Member();
			member.setMemberId(rs.getInt("MEMBER_ID"));
			member.setMemberName(rs.getString("MEMBER_NAME"));
			member.setMemberEmail(rs.getString("MEMBER_EMAIL"));
			member.setJoinDate(rs.getDate("JOIN_DATE").toLocalDate());
			members.add(member);
		}
		return members;
	}

	@Override
	public Member getMemberById(int memberId) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(MemberQueryMapper.getmemberById);
		pstmt.setInt(1, memberId);
		ResultSet rs = pstmt.executeQuery();

		Member member = new Member();
		if (rs.next()) {
			member.setMemberId(rs.getInt("MEMBER_ID"));
			member.setMemberName(rs.getString("MEMBER_NAME"));
			member.setMemberEmail(rs.getString("MEMBER_EMAIL"));
			member.setJoinDate(rs.getDate("JOIN_DATE").toLocalDate());
		}
		return member;
	}

	@Override
	public Member getMemberByEmail(String memberEmail) throws SQLException {

		PreparedStatement pstmt = connection.prepareStatement(MemberQueryMapper.getmemberByEmail);
		pstmt.setString(1, memberEmail);
		ResultSet rs = pstmt.executeQuery();

		Member member = new Member();
		if (rs.next()) {
			member.setMemberId(rs.getInt("MEMBER_ID"));
			member.setMemberName(rs.getString("MEMBER_NAME"));
			member.setMemberEmail(rs.getString("MEMBER_EMAIL"));
			member.setJoinDate(rs.getDate("JOIN_DATE").toLocalDate());
		}
		return member;
	}

    @Override
    public void updateMemberName(int memberId, String memberName) throws SQLException {
        PreparedStatement pstmt= connection.prepareStatement(MemberQueryMapper.updateMemberName);
        pstmt.setString(1, memberName);
        pstmt.setInt(2, memberId);
        pstmt.executeUpdate();
    }

    @Override
    public void updateMemberEmail(int memberId, String memberEmail) throws SQLException {
        PreparedStatement pstmt= connection.prepareStatement(MemberQueryMapper.updateMemberEmail);
        pstmt.setString(1,memberEmail);
        pstmt.executeUpdate();
    }

    @Override
    public void deleteMemberRecord(int memberId) throws SQLException{
        PreparedStatement pstmt= connection.prepareStatement(MemberQueryMapper.deleteMemberRecord);
        pstmt.setInt(1, memberId);
        pstmt.executeUpdate();
    }

    @Override
	public void createMemberTable() throws SQLException {
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(MemberQueryMapper.createTable);

	}

	@Override
	public int noOfLoanOnMemebr(int memberId) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(MemberQueryMapper.noOfLoanOnMember);
		pstmt.setInt(1, memberId);
		ResultSet rs= pstmt.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

}
