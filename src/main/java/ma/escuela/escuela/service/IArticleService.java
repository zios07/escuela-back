package ma.escuela.escuela.service;

import ma.escuela.escuela.domain.Article;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;

import java.util.List;

public interface IArticleService {

    Article addArticle(Article article) throws ServiceException;

    Article findArticle(long id) throws NotFoundException;

    List<Article> findAllArticles();

    void deleteArticle(long id) throws NotFoundException;

    Article updateArticle(Article article) throws NotFoundException;

}
