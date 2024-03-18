package com.estsoft.blogjpa2.dto;

import com.estsoft.blogjpa2.domain.Article;
import com.estsoft.blogjpa2.domain.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddCommentRequest {
	private String body;

	public AddCommentRequest(Comment comment) {
		this.body = comment.getBody();
	}

	public Comment toEntity() {
		return Comment.builder()
			.body(body)
			.build();
	}
}
