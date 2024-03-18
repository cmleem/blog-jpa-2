package com.estsoft.blogjpa2.controller;

import java.util.List;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.estsoft.blogjpa2.domain.Article;
import com.estsoft.blogjpa2.dto.AddArticleRequest;
import com.estsoft.blogjpa2.dto.ArticleResponse;
import com.estsoft.blogjpa2.dto.UpdateArticleRequest;
import com.estsoft.blogjpa2.service.BlogService;

@RestController //HTTP Response Body에 객체 데이터를 JSON 형식으로 반환
public class BlogApiController {
	private final BlogService blogService;

	public BlogApiController(BlogService blogService) {
		this.blogService = blogService;
	}

	@PostMapping("/api/articles")
	public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
		//@RequestBody -> HTTP 요청 시 응답에 해당하는 값을 애너테이션이 붙은 대상 객체 AddArticleRequest 에 매핑
		Article savedArticle = blogService.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
		//요청한 자원이 성공적으로 생성되었고 저장된 글 정보를 응답 객체에 담아 전송
	}

	@GetMapping("/api/articles")
	public ResponseEntity<List<ArticleResponse>> findAllArticles() {
		List<ArticleResponse> articles = blogService.findAll().stream().map(ArticleResponse::new).toList();

		return ResponseEntity.ok().body(articles);
	}

	@GetMapping("/api/articles/{id}")
	public ResponseEntity<ArticleResponse> findArticle(@PathVariable Long id) {
		Article article = blogService.findById(id);

		return ResponseEntity.ok().body(new ArticleResponse(article));
	}

	@DeleteMapping("/api/articles/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
		blogService.delete(id);

		return ResponseEntity.ok().build();
	}

	@PutMapping("/api/articles/{id}")
	public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody UpdateArticleRequest request) {
		Article updatedArticle = blogService.update(id, request);

		return ResponseEntity.ok().body(updatedArticle);
	}


}
