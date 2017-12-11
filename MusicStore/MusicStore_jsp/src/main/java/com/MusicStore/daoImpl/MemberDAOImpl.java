package com.MusicStore.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.weaver.MemberImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.MusicStore.Model.Member;
import com.MusicStore.Model.Music;
import com.MusicStore.Model.contact;
import com.MusicStore.dao.MemberDAO;
import com.jayway.jsonpath.Criteria;

public class MemberDAOImpl implements MemberDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addMember(Member member) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.openSession();
			session.save(member);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public List<Member> getMembers() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.openSession().createCriteria(Member.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	@Transactional
	public void deleteMember(Member member) {
		// TODO Auto-generated method stub

		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(member);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void updateMember(Member member) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.openSession();

			session.update(member);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Member getMember(int member_idx) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Member member = (Member) session.get(Member.class, member_idx);
		return member;
	}

}
