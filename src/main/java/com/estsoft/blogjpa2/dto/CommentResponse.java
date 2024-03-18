package com.estsoft.blogjpa2.dto;

import com.estsoft.blogjpa2.domain.Comment;

import lombok.Getter;

@Getter
public class CommentResponse {
	private String body;

	public CommentResponse(Comment comment) {
		this.body = comment.getBody();
	}
}
