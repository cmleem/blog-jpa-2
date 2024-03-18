package com.estsoft.blogjpa2.service;

import org.springframework.stereotype.Service;

import com.estsoft.blogjpa2.domain.Comment;
import com.estsoft.blogjpa2.dto.AddArticleRequest;
import com.estsoft.blogjpa2.dto.AddCommentRequest;
import com.estsoft.blogjpa2.repository.BlogCommentRepository;

@Service
public class BlogCommentService {
	private final BlogCommentRepository blogCommentRepository;

	public BlogCommentService(BlogCommentRepository blogCommentRepository) {
		this.blogCommentRepository = blogCommentRepository;
	}

	public Comment save(Long id, AddCommentRequest request) {

		return blogCommentRepository.save(request.toEntity());
	}

	public Comment findById(Long id) {
		return blogCommentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));
	}
}
