package com.estsoft.blogjpa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estsoft.blogjpa2.domain.Article;

public interface BlogRepository extends JpaRepository<Article, Long> {

}
