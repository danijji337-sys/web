package com.office.member;

public interface IMemberDao {

	public boolean isMember(String memId);
	
	public int InsertNewMember(MemberDto memberDto);
	
	public MemberDto selectMemberByMemId(String memId);
	
}
