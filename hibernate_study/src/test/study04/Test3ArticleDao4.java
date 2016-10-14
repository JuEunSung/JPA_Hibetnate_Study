package test.study04;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import study.study04.article.Article4;
import study.study04.article.ArticleDao4;
import study.study04.article.ArticleStatus;
import study.study04.member.Member4;
import study.study04.member.MemberDao4;
import study.study04.member.MemberStatus;
import study.study04.util.HibernateUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test3ArticleDao4 {

  private static ArticleDao4 articleDao;
  private static MemberDao4 memberDao;

  private static Member4 [] member = new Member4[3];
  private static Article4 [] article = new Article4[3];

  @BeforeClass
  public static void beforeClass() {

    articleDao = new ArticleDao4();
    memberDao = new MemberDao4();

    member[0] = new Member4("lee", "123", "이순신", MemberStatus.ACTIVATE);
    member[1] = new Member4("hong", "456", "홍길동", MemberStatus.WITHDRAWAL);
    member[2] = new Member4("ju", "789", "주은성", MemberStatus.ACTIVATE);


    article[0] = new Article4("첫번째 글입니다.", "첫번째 내용입니다.", ArticleStatus.PUBLIC);
    article[1] = new Article4("두번째 글입니다.", "두번째 내용입니다.", ArticleStatus.PRIVATE);
    article[2] = new Article4("세번째 글입니다.", "세번째 내용입니다.", ArticleStatus.PUBLIC);

    article[0].setMember(member[0]);
    article[1].setMember(member[1]);
    article[2].setMember(member[2]);

    Test1MemberDao4.insertMembers(memberDao, member);
  }

  @AfterClass
  public static void afterClass() {

    try {

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
      articleDao.insert(article[0]);
      articleDao.insert(article[1]);
      articleDao.insert(article[2]);
    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }

    assertTrue(true);
  }

  @Test
  public void test2select() {

    Article4 article1 = null;
    Article4 article2 = null;
    Article4 article3 = null;

    try {
      article1 = articleDao.select(article[0].getArticleNo());
      article2 = articleDao.select(article[1].getArticleNo());
      article3 = articleDao.select(article[2].getArticleNo());
    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }

    if(article[0].equals(article1) == true &&
        article[1].equals(article2) == true &&
        article[2].equals(article3) == true) {

      assertTrue(true);
    } else {
      assertTrue(false);
    }
  }

  @Test
  public void test3update() throws Exception {

    try {
      article[0].setStatus(ArticleStatus.REMOVE);
      article[1].setStatus(ArticleStatus.REMOVE);
      article[2].setStatus(ArticleStatus.REMOVE);

      articleDao.update(article[0]);
      articleDao.update(article[1]);
      articleDao.update(article[2]);
    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }

    Article4 article1 = articleDao.select(article[0].getArticleNo());
    Article4 article2 = articleDao.select(article[1].getArticleNo());
    Article4 article3 = articleDao.select(article[2].getArticleNo());

    if(article[0].equals(article1) == true &&
       article[1].equals(article2) == true &&
       article[2].equals(article3) == true) {

      assertTrue(true);
    } else {
      assertTrue(false);
    }
  }

  @Test
  public void test4delete() throws Exception {

    try {
      articleDao.delete(article[0]);
      articleDao.delete(article[1]);
      articleDao.delete(article[2]);
    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }
  }

  static void insertArticle(ArticleDao4 articleDao, Article4[] articles) {

    for(int i = 0; i < articles.length; i++) {
      try {
        articleDao.insert(articles[i]);
      } catch(Exception e) {
        e.printStackTrace();
        System.out.println("이미 데이터가 존재합니다.");
        try {
          articles[i] = articleDao.select(articles[i].getArticleNo());
        } catch(Exception e1) {
          e1.printStackTrace();
        }
      } // catch
    } // for
  }

  static void deleteArticle(ArticleDao4 articleDao, Article4[] articles) throws Exception {

    for(int i = 0; i < articles.length; i++)
      articleDao.delete(articles[i]);
  }
}
