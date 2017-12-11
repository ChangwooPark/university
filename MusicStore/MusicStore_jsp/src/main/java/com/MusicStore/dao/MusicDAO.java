package com.MusicStore.dao;

import java.util.List;

import com.MusicStore.Model.Music;
import com.MusicStore.Model.PlayList;

public interface MusicDAO {
	public void addMusic(Music music);

	public void updateMusic(Music music);

	public Music getMusic(int music_idx);

	public void deleteMusic(int music_idx);

	public List<Music> getMusics();

	public List<String> getAlbums();

	public List<Music> getAlbumtoMusic(String album);

	public List<Music> getVideoToMusic(String video);

}
