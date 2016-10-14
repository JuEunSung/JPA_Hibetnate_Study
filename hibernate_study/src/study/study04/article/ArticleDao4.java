package study.study04.article;

import java.util.List;

import study.study04.util.DaoTemplate;

public class ArticleDao4 {

  private DaoTemplate<Article4> getDaoTemplate() {

    return new DaoTemplate<Article4>();
  }

  public void insert(Article4 article) throws Exception {

    getDaoTemplate().insert(article);
  }

  public void update(Article4 article) throws Exception {

    getDaoTemplate().update(article);
  }

  public void delete(Article4 article) throws Exception {

    getDaoTemplate().delete(article);
  }

  public Article4 select(int articleNo) throws Exception {

    return getDaoTemplate().selectQuery("SELECT a FROM Article4 a WHERE article_no = " + articleNo);
  }

  public List<Article4> selectList() throws Exception {

    return getDaoTemplate().selectListQuery("SELECT a FROM Article4 a");
  }
}
