package study.study04.comments;

import java.util.List;

import study.study04.util.DaoTemplate;

public class CommentsDao4 {

  private DaoTemplate<Comments4> getDaoTemplate() {

    return new DaoTemplate<Comments4>();
  }

  public void insert(Comments4 comments) throws Exception {

    getDaoTemplate().insert(comments);
  }

  public List<Comments4> selectByArticleNo(int articleNo) throws Exception {

    String query = "SELECT c FROM Comments4 c WHERE c.article.articleNo = " + articleNo;

    return getDaoTemplate().selectListQuery(query);
  }

  public List<Comments4> selectByMemberNo(int memberNo) throws Exception {

    String query = "SELECT c FROM Comments4 c WHERE c.member.memberNo = " + memberNo;

    return getDaoTemplate().selectListQuery(query);
  }

  public void update(Comments4 comments) throws Exception {

    getDaoTemplate().update(comments);
  }

  public void delete(Comments4 comments) throws Exception {

    getDaoTemplate().delete(comments);
  }
}
