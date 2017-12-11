package com.MusicStore.dao;

import java.util.List;

import com.MusicStore.Model.Member;
import com.MusicStore.Model.Music;
import com.MusicStore.Model.PlayList;

public interface PlayListDAO {
	public void addPlayList(PlayList playlist);

	public void updatePlayList(PlayList playlist);

	public PlayList getPlayList(int playlist_idx);

	public void deletePlayList(int playlist_idx);

	public List<PlayList> getPlayLists(Member member);

	public void addMapping(Music music, PlayList playlist);
}
