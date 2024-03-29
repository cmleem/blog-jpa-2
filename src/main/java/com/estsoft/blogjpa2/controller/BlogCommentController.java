package com.estsoft.blogjpa2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estsoft.blogjpa2.domain.Article;
import com.estsoft.blogjpa2.domain.Comment;
import com.estsoft.blogjpa2.dto.AddArticleRequest;
import com.estsoft.blogjpa2.dto.AddCommentRequest;
import com.estsoft.blogjpa2.dto.CommentResponse;
import com.estsoft.blogjpa2.service.BlogCommentService;
import com.estsoft.blogjpa2.service.BlogService;

@Controller
public class BlogCommentController {

	private final BlogCommentService blogCommentService;
	private final BlogService blogService;
	public BlogCommentController(BlogCommentService blogCommentService, BlogService blogService) {
		this.blogCommentService = blogCommentService;
		this.blogService = blogService;
	}

	@PostMapping("/comments/{articleId}")
	public ResponseEntity<Comment> addComment(@PathVariable(value = "articleId") Long articleId, @RequestBody AddCommentRequest request) {
		Article article = blogService.findById(articleId);
		Comment savedComment = blogCommentService.save(article, request);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedComment);
	}

	@GetMapping("/comments/{articleId}")
	public ResponseEntity<Article> readComment(@PathVariable(value = "articleId") Long articleId) {
		Article article = blogService.findById(articleId);
		return ResponseEntity.ok().body(article);
	}
}
