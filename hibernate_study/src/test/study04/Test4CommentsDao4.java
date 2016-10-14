package test.study04;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import study.study04.article.Article4;
import study.study04.article.ArticleDao4;
import study.study04.article.ArticleStatus;
import study.study04.comments.Comments4;
import study.study04.comments.CommentsDao4;
import study.study04.comments.CommentsStatus;
import study.study04.member.Member4;
import study.study04.member.MemberDao4;
import study.study04.member.MemberStatus;
import study.study04.util.HibernateUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test4CommentsDao4 {

  private static MemberDao4 memberDao = new MemberDao4();
  private static ArticleDao4 articleDao = new ArticleDao4();
  private static CommentsDao4 commentsDao = new CommentsDao4();

  private static Member4[] member = new Member4[3];
  private static Article4[] article = new Article4[3];
  private static Comments4[] comments = new Comments4[3];

  @BeforeClass
  public static void beforeClass() {

    member[0] = new Member4("lee", "123", "이순신", MemberStatus.ACTIVATE);
    member[1] = new Member4("hong", "456", "홍길동", MemberStatus.WITHDRAWAL);
    member[2] = new Member4("ju", "789", "주은성", MemberStatus.ACTIVATE);

    Test1MemberDao4.insertMembers(memberDao, member);

    article[0] = new Article4("첫번째 글입니다.", "첫번째 내용입니다.", ArticleStatus.PUBLIC);
    article[1] = new Article4("두번째 글입니다.", "두번째 내용입니다.", ArticleStatus.PRIVATE);
    article[2] = new Article4("세번째 글입니다.", "세번째 내용입니다.", ArticleStatus.PUBLIC);

    article[0].setMember(member[0]);
    article[1].setMember(member[1]);
    article[2].setMember(member[2]);

    Test3ArticleDao4.insertArticle(articleDao, article);

    comments[0] = new Comments4("첫번째 댓글입니다.", CommentsStatus.ACTIVATE);
    comments[1] = new Comments4("두번째 댓글입니다.", CommentsStatus.NON_ACTIVATE);
    comments[2] = new Comments4("세번째 댓글입니다.", CommentsStatus.ACTIVATE);
  }

  @AfterClass
  public static void afterClass() {

    try {

      Test3ArticleDao4.deleteArticle(articleDao, article);

      Test1MemberDao4.deleteMembers(memberDao, member);

    } catch(Exception e) {
      System.out.println("afterClass에서 예외 발생!!");
      e.printStackTrace();
    }

    HibernateUtil.shutdown();

  }

  @Test
  public void test1insert() {

    try {
      comments[0].setArticle(article[0]);
      comments[1].setArticle(article[1]);
      comments[2].setArticle(article[2]);

      comments[0].setMember(member[0]);
      comments[1].setMember(member[1]);
      comments[2].setMember(member[2]);

      comments[0].setRegisterDate(new Date());
      comments[1].setRegisterDate(new Date());
      comments[2].setRegisterDate(new Date());

      commentsDao.insert(comments[0]);
      commentsDao.insert(comments[1]);
      commentsDao.insert(comments[2]);

      assertTrue(true);
    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }
  }

  @Test
  public void test2select() {

    try {
      List<Comments4> commentsList1 = commentsDao.selectByArticleNo(article[0].getArticleNo());
      List<Comments4> commentsList2 = commentsDao.selectByArticleNo(article[1].getArticleNo());
      List<Comments4> commentsList3 = commentsDao.selectByArticleNo(article[2].getArticleNo());

      if(commentsList1.size() > 0 &&
          commentsList2.size() > 0 &&
          commentsList3.size() > 0) {

        if(commentsList1.get(0).equals(comments[0]) == true &&
            commentsList2.get(0).equals(comments[1]) == true &&
            commentsList3.get(0).equals(comments[2]) == true) {

          assertTrue(true);
        }
      }
    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }
  }

  @Test
  public void test3update() {

    try {

      comments[0].setLikes(3);
      comments[1].setLikes(3);
      comments[2].setLikes(3);

      commentsDao.update(comments[0]);
      commentsDao.update(comments[1]);
      commentsDao.update(comments[2]);

      assertTrue(true);

    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }
  }

  @Test
  public void test4delete() {

    try {

      commentsDao.delete(comments[0]);
      commentsDao.delete(comments[1]);
      commentsDao.delete(comments[2]);

    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }
  }

}
