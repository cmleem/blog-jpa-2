package com.estsoft.blogjpa2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.estsoft.blogjpa2.domain.Article;
import com.estsoft.blogjpa2.dto.ArticleListViewResponse;
import com.estsoft.blogjpa2.dto.ArticleViewResponse;
import com.estsoft.blogjpa2.service.BlogService;

@Controller
public class BlogViewController {
	private final BlogService blogService;

	public BlogViewController(BlogService blogService) {
		this.blogService = blogService;
	}

	@GetMapping("/articles")
	public String getArticles(Model model) {
		List<ArticleListViewResponse> articles = blogService.findAll()
			.stream()
			.map(ArticleListViewResponse::new)
			.toList();
		model.addAttribute("articles", articles);

		return "articleList";
	}

	@GetMapping("/articles/{id}")
	public String getArticle(@PathVariable Long id, Model model) {
		Article article = blogService.findById(id);
		model.addAttribute("article", new ArticleViewResponse(article));

		return "article";
	}

	@GetMapping("/new-article")
	public String newArticle(@RequestParam(required = false) Long id, Model model) {
		if (id == null) {
			model.addAttribute("article", new ArticleViewResponse());
		} else {
			Article article = blogService.findById(id);
			model.addAttribute("article", new ArticleViewResponse(article));
		}
		return "newArticle";
	}
}
