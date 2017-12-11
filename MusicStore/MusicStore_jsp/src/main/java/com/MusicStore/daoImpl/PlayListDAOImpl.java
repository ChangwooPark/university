package com.MusicStore.daoImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.MusicStore.Model.Member;
import com.MusicStore.Model.Music;
import com.MusicStore.Model.PlayList;
import com.MusicStore.dao.PlayListDAO;

public class PlayListDAOImpl implements PlayListDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addPlayList(PlayList playlist) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.save(playlist);
		session.close();
	}

	@Override
	@Transactional
	public void updatePlayList(PlayList playlist) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(playlist);
		session.close();
	}

	@Override
	@Transactional
	public PlayList getPlayList(int playlist_idx) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		PlayList playlist = (PlayList) session
				.get(PlayList.class, playlist_idx);
		session.close();
		return playlist;
	}

	@Override
	public List<PlayList> getPlayLists(Member member) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.openSession();
			List<PlayList> list = session
					.createCriteria(PlayList.class)
					.add(Restrictions.eq("member.member_idx",
							member.getMember_idx())).list();
			session.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public void deletePlayList(int playlist_idx) {
		// TODO Auto-generated method stub
		PlayList playlist = getPlayList(playlist_idx);
		Session session = sessionFactory.getCurrentSession();
		session.delete(playlist);
	}

	@Override
	public void addMapping(Music music, PlayList playlist) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Set<Music> musics = new HashSet<Music>();
		// Set<PlayList> playlists = new HashSet<PlayList>();
		// playlists.add(playlist);
		// music.setPlaylists(playlists);
		// playlist.getMusics().add(music);
		musics.add(music);
		playlist.setMusics(musics);

		session.saveOrUpdate(playlist);
	}
}
