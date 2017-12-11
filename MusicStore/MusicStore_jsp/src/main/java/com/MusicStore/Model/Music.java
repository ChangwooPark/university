package com.MusicStore.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

public class Music {
	private int music_idx;
	private String name;
	private String regis_date;
	private String artist;
	private String genre;
	private int hits;
	private String album;
	private String picture;
	private String music;
	private String video;
	private Set<Comment> comments = new HashSet<Comment>();
	private Set<PlayList> playlists = new HashSet<PlayList>();

	// private MultipartFile picture;
	// private MultipartFile extention_music;
	// private MultipartFile extention_video;
	public int getMusic_idx() {
		return music_idx;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setMusic_idx(int music_idx) {
		this.music_idx = music_idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegis_date() {
		return regis_date;
	}

	public void setRegis_date(String regis_date) {
		this.regis_date = regis_date;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<PlayList> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Set<PlayList> playlists) {
		this.playlists = playlists;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getMusic() {
		return music;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

}
