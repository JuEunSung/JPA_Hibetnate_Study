package study.study04.article;

import java.util.List;

import study.study04.util.UpdateDaoTemplate;

public class ArticleDao4 extends UpdateDaoTemplate<Article4> {

  public Article4 select(int articleNo) throws Exception {

    return getDaoTemplate().selectQuery("SELECT a FROM Article4 a WHERE article_no = " + articleNo);
  }

  public List<Article4> selectList() throws Exception {

    return getDaoTemplate().selectListQuery("SELECT a FROM Article4 a");
  }
}
