package com.estsoft.blogjpa2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.estsoft.blogjpa2.domain.Article;
import com.estsoft.blogjpa2.domain.Comment;
import com.estsoft.blogjpa2.dto.AddArticleRequest;
import com.estsoft.blogjpa2.dto.AddCommentRequest;
import com.estsoft.blogjpa2.service.BlogCommentService;
import com.estsoft.blogjpa2.service.BlogService;

@Controller
public class BlogCommentController {
	private final BlogCommentService blogCommentService;

	public BlogCommentController(BlogCommentService blogCommentService) {
		this.blogCommentService = blogCommentService;
	}

	@PostMapping("/comments/{articleId}")
	public ResponseEntity<Comment> addComment(@PathVariable Long articleId, @RequestBody AddCommentRequest request) {

		Comment savedComment = blogCommentService.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedComment);
	}

}
