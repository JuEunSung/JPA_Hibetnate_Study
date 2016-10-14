package test.study04;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import study.study04.member.Member4;
import study.study04.member.MemberDao4;
import study.study04.member.MemberStatus;
import study.study04.util.HibernateUtil;

/**
 * 테이블간 관계를 짓기 위해 Article 엔티티가 추가됩니다.
 *
 * 또한 @OneToMany 어노테이션을 통해 Member - Article 의 연관(관계)를 지어보겠습니다.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test1MemberDao4 {

  private static MemberDao4 memberDao;
  private static Member4 [] member = new Member4[3];

  @BeforeClass
  public static void beforeClass() {

    memberDao = new MemberDao4();

    member[0] = new Member4("lee", "123", "이순신", MemberStatus.ACTIVATE);
    member[1] = new Member4("hong", "456", "홍길동", MemberStatus.WITHDRAWAL);
    member[2] = new Member4("ju", "789", "주은성", MemberStatus.ACTIVATE);
  }

  @AfterClass
  public static void afterClass() {

    HibernateUtil.shutdown();
  }

  @Test
  public void test1insert() {

    /*
     * 테스트 조건
     *
     *  1. 3번의 insert 과정에서 Exception이 발생하지 않아야 한다.
     *  2. 데이터베이스에서 조회한 row가 모두 일치해야 한다.
     */

    try {
      memberDao.insert(member[0]);
      memberDao.insert(member[1]);
      memberDao.insert(member[2]);

      long resultRow = memberDao.selectCount();

      if(resultRow == 3) {
        assertTrue(true);
      } else {
        assertTrue(false);
      }

    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }

  }

  @Test
  public void test2select() {

    /*
     * 테스트 조건
     *
     *  1. 3번의 select 과정에서 Exception이 발생하지 않아야 한다.
     *  2. 3개의 결과가 null이 아니어야 한다.
     */

    Member4 member1 = null;
    Member4 member2 = null;
    Member4 member3 = null;

    try {
      member1 = memberDao.selectById(member[0].getMemberId());
      member2 = memberDao.selectById(member[1].getMemberId());
      member3 = memberDao.selectById(member[2].getMemberId());
    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }

    if(member[0].equals(member1) == true &&
       member[1].equals(member2) == true &&
       member[2].equals(member3) == true) {

      System.out.println(member1);
      System.out.println(member2);
      System.out.println(member3);

      assertTrue(true);
    } else {
      assertTrue(false);
    }

  }

  @Test
  public void test3update() throws Exception {

    /*
     * 테스트 조건
     *
     *  1. 3번의 update 과정에서 Exception이 발생하지 않아야 한다.
     *  2. 데이터베이스에서 3개의 Member를 조회하고 값이 같은지 비교한다.
     */

    try {
      member[0].setStatus(MemberStatus.QUIESCENCE);
      member[1].setStatus(MemberStatus.QUIESCENCE);
      member[2].setStatus(MemberStatus.QUIESCENCE);

      memberDao.update(member[0]);
      memberDao.update(member[1]);
      memberDao.update(member[2]);
    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }

    Member4 member1 = memberDao.selectById(member[0].getMemberId());
    Member4 member2 = memberDao.selectById(member[1].getMemberId());
    Member4 member3 = memberDao.selectById(member[2].getMemberId());

    if(member[0].equals(member1) == true &&
       member[1].equals(member2) == true &&
       member[2].equals(member3) == true) {

      assertTrue(true);
    } else {
      assertTrue(false);
    }
  }

  @Test
  public void test4delete() throws Exception {

    /*
     * 테스트 조건
     *
     *  1. 3번의 delete 과정에서 Exception이 발생하지 않아야 한다.
     *  2. 데이터베이스에서 조회한 row count가 0이어야 한다.
     */

    try {
      memberDao.delete(member[0]);
      memberDao.delete(member[1]);
      memberDao.delete(member[2]);
    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }

    long rowCount = memberDao.selectCount();

    if(rowCount != 0) {
      assertTrue(false);
    }

    assertTrue(true);
  }

  static void insertMembers(MemberDao4 memberDao, Member4 [] members) {

    for(int i = 0; i < members.length; i++) {
      try {
        memberDao.insert(members[i]);
      } catch(Exception e) {
        e.printStackTrace();
        System.out.println("이미 데이터가 존재합니다.");
        try {
          members[i] = memberDao.selectById(members[i].getMemberId());
        } catch(Exception e1) {
          e1.printStackTrace();
        }
      } // catch
    } // for
  }

  static void deleteMembers(MemberDao4 memberDao, Member4 [] members) throws Exception {

    for(int i = 0; i < members.length; i++)
      memberDao.delete(members[i]);
  }
}
