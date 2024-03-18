package com.estsoft.blogjpa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estsoft.blogjpa2.domain.Comment;

@Repository
public interface BlogCommentRepository extends JpaRepository<Comment, Long> {
}
