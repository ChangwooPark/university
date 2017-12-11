package com.MusicStore.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.MusicStore.Model.Member;
import com.MusicStore.Model.contact;

public interface MemberDAO {
	public void addMember(Member member);

	public void updateMember(Member member);

	public Member getMember(int member_idx);

	public void deleteMember(Member member);

	public List<Member> getMembers();
}
