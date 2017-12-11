package com.MusicStore.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PlayList {
	private int playlist_idx;
	private Member member;
	private Set<Music> musics = new HashSet<Music>();

	public int getPlaylist_idx() {
		return playlist_idx;
	}

	public void setPlaylist_idx(int playlist_idx) {
		this.playlist_idx = playlist_idx;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Set<Music> getMusics() {
		return musics;
	}

	public void setMusics(Set<Music> musics) {
		this.musics = musics;
	}

}
