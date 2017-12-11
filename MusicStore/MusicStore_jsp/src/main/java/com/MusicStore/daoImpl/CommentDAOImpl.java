package com.MusicStore.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.MusicStore.Model.Comment;
import com.MusicStore.dao.CommentDAO;

public class CommentDAOImpl implements CommentDAO {

	private SessionFactory sessionFactory;
	private Session session;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addComment(Comment comment) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		session.save(comment);
	}

	@Override
	public void updateComment(Comment comment) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		session.update(comment);
	}

	@Override
	public Comment getComment(int comment_idx) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		Comment comment = (Comment) session.get(Comment.class, comment_idx);
		return comment;
	}

	@Override
	public List<Comment> getComments() {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		return session.createQuery("from Comment").list();
	}

	@Override
	public void deleteComment(int comment_idx) {
		// TODO Auto-generated method stub
		Comment comment = getComment(comment_idx);
		session = sessionFactory.getCurrentSession();
		session.delete(comment);
	}
}
