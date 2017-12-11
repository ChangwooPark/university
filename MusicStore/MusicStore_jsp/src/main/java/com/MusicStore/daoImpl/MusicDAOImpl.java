package com.MusicStore.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.MusicStore.Model.Music;
import com.MusicStore.Model.PlayList;
import com.MusicStore.dao.MusicDAO;

public class MusicDAOImpl implements MusicDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session session;

	@Override
	@Transactional
	public void addMusic(Music music) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.openSession();
			session.save(music);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	@Transactional
	public void updateMusic(Music music) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		session.update(music);
		session.close();
	}

	@Override
	@Transactional
	public Music getMusic(int music_idx) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		Music music = (Music) session.get(Music.class, music_idx);
		session.close();
		return music;
	}

	@Override
	@Transactional
	public List<Music> getMusics() {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		return session.createCriteria(Music.class).list();
	}

	@Override
	@Transactional
	public void deleteMusic(int music_idx) {
		// TODO Auto-generated method stub
		Music music = getMusic(music_idx);
		session = sessionFactory.getCurrentSession();
		session.delete(music);
	}

	@Override
	public List<String> getAlbums() {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.groupProperty("album"));
		System.out.println(projectionList.getProjection(0));
		return session.createCriteria(Music.class)
				.setProjection(projectionList).list();
	}

	@Override
	public List<Music> getAlbumtoMusic(String album) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		List<Music> list = session.createCriteria(Music.class).setMaxResults(1)
				.add(Restrictions.eq("album", album)).list();
		return list;
	}

	@Override
	public List<Music> getVideoToMusic(String video) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		List<Music> list = session.createCriteria(Music.class)
				.add(Restrictions.eq("video", video)).list();
		session.close();
		return list;
	}
}
