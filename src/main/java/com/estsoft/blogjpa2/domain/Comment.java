package com.estsoft.blogjpa2.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "article_id", nullable = false)
	private Long articleId;

	@Column(name = "body", nullable = false)
	private String body;

	@CreatedDate
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@OneToOne
	@JoinColumn(name = "article_id")
	private Article article;

	@Builder
	public Comment(String body) {
		this.body = body;
	}


}
