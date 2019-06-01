package ma.escuela.escuela.service.impl;

import ma.escuela.escuela.domain.Article;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;
import ma.escuela.escuela.repository.ArticleRepository;
import ma.escuela.escuela.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService implements IArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article addArticle(Article article) throws ServiceException {
        return articleRepository.save(article);
    }

    @Override
    public Article findArticle(long id) throws NotFoundException {
        Optional<Article> articleOptional = articleRepository.findById(id);
        if (!articleOptional.isPresent())
            throw new NotFoundException("ARTICLE.NOT.FOUND", "Article not found with id : " + id);
        return articleOptional.get();
    }

    @Override
    public List<Article> findAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public void deleteArticle(long id) throws NotFoundException {
        articleRepository.deleteById(id);
    }

    @Override
    public Article updateArticle(Article article) throws NotFoundException {
        return articleRepository.save(article);
    }
}
