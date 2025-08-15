package com.library.util.query;

import java.security.PublicKey;

public interface MemberQueryMapper {
	
	public String createTable="CREATE TABLE MEMBER( MEMBER_ID SERIAL PRIMARY KEY , MEMBER_NAME VARCHAR(20) NOT NULL, MEMBER_EMAIL VARCHAR(20) NOT NULL UNIQUE, JOIN_DATE DATE DEFAULT CURRENT_DATE)";
	public String getmembers="SELECT * FROM MEMBER WHERE IS_ACTIVE= TRUE";
	public String insertmember="INSERT INTO MEMBER(MEMBER_NAME, MEMBER_EMAIL) VALUES(?,?)";
	public String getmemberById="SELECT * FROM MEMBER WHERE MEMBER_ID=? AND IS_ACTIVE= TRUE";
	public String getmemberByEmail="SELECT * FROM MEMBER WHERE MEMBER_EMAIL LIKE ? AND IS_ACTIVE= TRUE";

    public String updateMemberName="UPDATE MEMBER SET MEMBER_NAME=? WHERE MEMBER_ID=? AND IS_ACTIVE= TRUE";
    public String updateMemberEmail="UPDATE MEMBER SET MEMBER_EMAIL=? WHERE MEMBER_ID=? AND IS_ACTIVE= TRUE";

    public String deleteMemberRecord="UPDATE MEMBER SET IS_ACTIVE= FALSE WHERE MEMBER_ID=?";
    
    public String noOfLoanOnMember= "SELECT COUNT(MEMBER_ID) FROM LOAN WHERE MEMBER_ID=? AND RETURN_DATE is null";
}
