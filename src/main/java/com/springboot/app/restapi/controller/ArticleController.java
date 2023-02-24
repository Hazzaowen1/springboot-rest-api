package com.springboot.app.restapi.controller;

import com.springboot.app.restapi.dao.ArticleDao;
import com.springboot.app.restapi.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// A simple Springboot RESTAPI which returns a JSON to the
// Every URL path has to be unique
@RestController
@CrossOrigin
public class ArticleController {

    private final ArticleDao articleDao;

    @Autowired
    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }


    @GetMapping("/articles")
    public List<Article> getArticles() {
        return articleDao.findAll();
    }

    @GetMapping("/articles/{id}")
    public Article getArticle(@PathVariable Long id) {
        Optional<Article> articleById = articleDao.findById(id);
        if(articleById.isPresent()){
            return articleById.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article with id " + id + "not found" );
        }
    }

    @PostMapping("/articles")
    public void postArticle(@RequestBody Article article){
        articleDao.save(article);
    }
}
