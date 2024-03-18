package com.estsoft.blogjpa2.dto;

import com.estsoft.blogjpa2.domain.Article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddArticleRequest {
	//컨트롤러에서 요청한 본문을 받을 객체

	private String title;
	private String content;

	public Article toEntity() {
		return Article.builder()
			.title(title)
			.content(content)
			.build();
	}
}
