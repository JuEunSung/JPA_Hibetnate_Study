package study.study04.comments;

import java.util.List;

import study.study04.util.UpdateDaoTemplate;

public class CommentsDao4 extends UpdateDaoTemplate <Comments4> {

  public List<Comments4> selectByArticleNo(int articleNo) throws Exception {

    String query = "SELECT c FROM Comments4 c WHERE c.article.articleNo = " + articleNo;

    return getDaoTemplate().selectListQuery(query);
  }

  public List<Comments4> selectByMemberNo(int memberNo) throws Exception {

    String query = "SELECT c FROM Comments4 c WHERE c.member.memberNo = " + memberNo;

    return getDaoTemplate().selectListQuery(query);
  }
}
