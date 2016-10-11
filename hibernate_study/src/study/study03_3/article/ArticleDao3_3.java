package study.study03_3.article;

import java.util.List;

import study.study03_3.util.DaoTemplate;

public class ArticleDao3_3 {

  private DaoTemplate<Article3_3> getDaoTemplate() {

    return new DaoTemplate<Article3_3>();
  }

  public void insert(Article3_3 article) throws Exception {

    getDaoTemplate().insert(article);
  }

  public void update(Article3_3 article) throws Exception {

    getDaoTemplate().update(article);
  }

  public void delete(Article3_3 article) throws Exception {

    getDaoTemplate().delete(article);
  }

  public Article3_3 select(int articleNo) throws Exception {

    return getDaoTemplate().selectQuery("SELECT a FROM Article3_3 a WHERE article_no = " + articleNo);
  }

  public List<Article3_3> selectList() throws Exception {

    return getDaoTemplate().selectListQuery("SELECT a FROM Article3_3 a");
  }
}
