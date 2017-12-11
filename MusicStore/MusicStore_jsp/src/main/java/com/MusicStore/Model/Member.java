package com.MusicStore.Model;

import java.util.HashSet;
import java.util.Set;

public class Member {
	private int member_idx;
	private String id;
	private String pass;
	private String name;
	private String address;
	private String e_mail;
	private String phone;
	private Set<Comment> comments = new HashSet<Comment>();
	private Set<PlayList> playlists = new HashSet<PlayList>();

	public int getMember_idx() {
		return member_idx;
	}

	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

}
