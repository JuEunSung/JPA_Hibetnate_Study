package test.study03;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import study.study03.Article3;
import study.study03.ArticleDao3;
import study.study03.ArticleStatus;
import study.study03.HibernateUtil;
import study.study03.Member3;
import study.study03.MemberDao3;
import study.study03.MemberStatus;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArticleDao3Test {

  private static ArticleDao3 articleDao;
  private static MemberDao3 memberDao;

  private static Member3 [] member = new Member3[3];
  private static Article3 [] article = new Article3[3];

  @BeforeClass
  public static void beforeClass() {

    articleDao = new ArticleDao3();
    memberDao = new MemberDao3();

    member[0] = new Member3("lee", "123", "이순신", MemberStatus.ACTIVATE);
    member[1] = new Member3("hong", "456", "홍길동", MemberStatus.WITHDRAWAL);
    member[2] = new Member3("ju", "789", "주은성", MemberStatus.ACTIVATE);

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

    article[0] = new Article3("첫번째 글입니다.", "첫번째 내용입니다.", ArticleStatus.PUBLIC);
    article[1] = new Article3("두번째 글입니다.", "두번째 내용입니다.", ArticleStatus.PRIVATE);
    article[2] = new Article3("세번째 글입니다.", "세번째 내용입니다.", ArticleStatus.PUBLIC);

    article[0].setMember(member[0]);
    article[1].setMember(member[1]);
    article[2].setMember(member[2]);
  }

  @AfterClass
  public static void afterClass() {

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
    }
  }
}
