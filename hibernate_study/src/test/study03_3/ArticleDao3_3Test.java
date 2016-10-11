package test.study03_3;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import study.study03_3.article.Article3_3;
import study.study03_3.article.ArticleDao3_3;
import study.study03_3.article.ArticleStatus;
import study.study03_3.member.Member3_3;
import study.study03_3.member.MemberDao3_3;
import study.study03_3.member.MemberStatus;
import study.study03_3.util.HibernateUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArticleDao3_3Test {

  private static ArticleDao3_3 articleDao;
  private static MemberDao3_3 memberDao;

  private static Member3_3 [] member = new Member3_3[3];
  private static Article3_3 [] article = new Article3_3[3];

  @BeforeClass
  public static void beforeClass() {

    articleDao = new ArticleDao3_3();
    memberDao = new MemberDao3_3();

    member[0] = new Member3_3("lee", "123", "이순신", MemberStatus.ACTIVATE);
    member[1] = new Member3_3("hong", "456", "홍길동", MemberStatus.WITHDRAWAL);
    member[2] = new Member3_3("ju", "789", "주은성", MemberStatus.ACTIVATE);

    try {
      memberDao.insert(member[0]);
      memberDao.insert(member[1]);
      memberDao.insert(member[2]);
    } catch(Exception e) {
      System.out.println("이미 데이터가 존재합니다.");
      try {
        member[0] = memberDao.selectById(member[0].getMemberId());
        member[1] = memberDao.selectById(member[1].getMemberId());
        member[2] = memberDao.selectById(member[2].getMemberId());
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }

    article[0] = new Article3_3("첫번째 글입니다.", "첫번째 내용입니다.", ArticleStatus.PUBLIC);
    article[1] = new Article3_3("두번째 글입니다.", "두번째 내용입니다.", ArticleStatus.PRIVATE);
    article[2] = new Article3_3("세번째 글입니다.", "세번째 내용입니다.", ArticleStatus.PUBLIC);

    article[0].setMember(member[0]);
    article[1].setMember(member[1]);
    article[2].setMember(member[2]);
  }

  @AfterClass
  public static void afterClass() {

    try {
      memberDao.delete(member[0]);
      memberDao.delete(member[1]);
      memberDao.delete(member[2]);
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

    Article3_3 article1 = null;
    Article3_3 article2 = null;
    Article3_3 article3 = null;

    try {
      article1 = articleDao.select(article[0].getArticleNo());
      article2 = articleDao.select(article[1].getArticleNo());
      article3 = articleDao.select(article[2].getArticleNo());
    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }

    if(equalsArticle(article[0], article1) == true &&
        equalsArticle(article[1], article2) == true &&
        equalsArticle(article[2], article3) == true) {

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

    Article3_3 article1 = articleDao.select(article[0].getArticleNo());
    Article3_3 article2 = articleDao.select(article[1].getArticleNo());
    Article3_3 article3 = articleDao.select(article[2].getArticleNo());

    if(equalsArticle(article[0], article1) == true &&
        equalsArticle(article[1], article2) == true &&
        equalsArticle(article[2], article3) == true) {

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

  static boolean equalsArticle(Article3_3 article1, Article3_3 article2) {

    if(article1 == null || article2 == null) {
      return false;
    }

    if((article1 instanceof Article3_3) == false) {
      return false;
    }
    if((article2 instanceof Article3_3) == false) {
      return false;
    }

    // 동일성 비교
    if(article1 == article2) {
      return true;
    }

    // 동등성 비교
    if(article1.getArticleNo() != article2.getArticleNo()) {
      return false;
    }
    if(article1.getTitle().equals(article2.getTitle()) == false) {
      return false;
    }
    if(article1.getContents().equals(article2.getContents()) == false) {
      return false;
    }
    if(article1.getStatus().equals(article2.getStatus()) == false) {
      return false;
    }
    if(article1.getLikes() != article2.getLikes()) {
      return false;
    }
    if(article1.getHits() != article2.getHits()) {
      return false;
    }
    if(MemberDao3_3Test.equalsMember(article1.getMember(), article2.getMember()) == false) {
      return false;
    }

    return true;
  }
}
