package com.estsoft.blogjpa2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.estsoft.blogjpa2.domain.Article;
import com.estsoft.blogjpa2.domain.Comment;
import com.estsoft.blogjpa2.dto.AddArticleRequest;
import com.estsoft.blogjpa2.dto.AddCommentRequest;
import com.estsoft.blogjpa2.dto.UpdateArticleRequest;
import com.estsoft.blogjpa2.repository.BlogRepository;

import jakarta.transaction.Transactional;

@Service
public class BlogService {
	private final BlogRepository blogRepository;

	public BlogService(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}

	public Article save(AddArticleRequest request) {
		//AddArticleRequest 클래스에 저장된 값들을 article 데이터베이스에 저장
		return blogRepository.save(request.toEntity());
	}

	public List<Article> findAll() {
		//article 테이블에 저장된 모든 데이터 조회
		return blogRepository.findAll();
	}

	public Article findById(Long id) {
		return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));
	}

	public void delete(Long id) {
		blogRepository.deleteById(id);
	}

	@Transactional
	public Article update(Long id, UpdateArticleRequest request) {
		Article article = blogRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("not found: " + id));
		article.update(request.getTitle(), request.getContent());
		return article;
	}



}
