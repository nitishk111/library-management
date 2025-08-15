package com.library.model;

import java.time.LocalDate;

public class Member {

	private int memberId;
	private String memberName;
	private String memberEmail;
	private LocalDate joinDate;
    private boolean isActive;
	
	public Member(String memberName, String memberEmail) {
		super();
		this.memberName = memberName;
		this.memberEmail = memberEmail;
	}

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

    @Override
	public String toString() {
		return "Member: memberId=" + memberId + ", memberName=" + memberName + ", memberEmail=" + memberEmail
				+ ", joinDate=" + joinDate;
	}
	
	
}
