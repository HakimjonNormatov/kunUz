package org.example.kunuz.repository;

import org.example.kunuz.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArticleRepo extends JpaRepository<Article, UUID> {
}
