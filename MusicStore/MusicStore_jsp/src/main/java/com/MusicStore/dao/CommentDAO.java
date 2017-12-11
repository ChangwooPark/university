package com.MusicStore.dao;

import java.util.List;

import com.MusicStore.Model.Comment;

public interface CommentDAO {
	public void addComment(Comment comment);

	public void updateComment(Comment comment);

	public Comment getComment(int comment_idx);

	public void deleteComment(int comment_idx);

	public List<Comment> getComments();
}
