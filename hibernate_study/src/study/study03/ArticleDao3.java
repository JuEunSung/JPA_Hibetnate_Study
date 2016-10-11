package study.study03;

import java.util.List;

public class ArticleDao3 {

  private DaoTemplate<Article3> getDaoTemplate() {

    return new DaoTemplate<Article3>();
  }

  public void insert(Article3 article) throws Exception {

    getDaoTemplate().insert(article);
  }

  public void update(Article3 article) throws Exception {

    getDaoTemplate().update(article);
  }

  public void delete(Article3 article) throws Exception {

    getDaoTemplate().delete(article);
  }

  public Article3 select(int articleNo) throws Exception {

    return getDaoTemplate().selectQuery("SELECT a FROM Article3 a WHERE article_no = " + articleNo);
  }

  public List<Article3> selectList() throws Exception {

    return getDaoTemplate().selectListQuery("SELECT a FROM Article3 a");
  }
}
