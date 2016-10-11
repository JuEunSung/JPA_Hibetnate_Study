package test.study03_3;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import study.study03_3.member.Member3_3;
import study.study03_3.member.MemberDao3_3;
import study.study03_3.member.MemberStatus;
import study.study03_3.util.HibernateUtil;

/**
 * 테이블간 관계를 짓기 위해 Article 엔티티가 추가됩니다.
 *
 * 또한 @OneToMany 어노테이션을 통해 Member - Article 의 연관(관계)를 지어보겠습니다.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberDao3_3Test {

  private static MemberDao3_3 memberDao;
  private static Member3_3 [] member = new Member3_3[3];

  @BeforeClass
  public static void before() {

    memberDao = new MemberDao3_3();

    member[0] = new Member3_3("lee", "123", "이순신", MemberStatus.ACTIVATE);
    member[1] = new Member3_3("hong", "456", "홍길동", MemberStatus.WITHDRAWAL);
    member[2] = new Member3_3("ju", "789", "주은성", MemberStatus.ACTIVATE);
  }

  @AfterClass
  public static void after() {

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

    long resultRow = -1;

    try {
      memberDao.insert(member[0]);
      memberDao.insert(member[1]);
      memberDao.insert(member[2]);

      resultRow = memberDao.selectCount();
    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }

    if(resultRow != 3) {
      assertTrue(false);
    }

    assertTrue(true);
  }

  @Test
  public void test2select() {

    /*
     * 테스트 조건
     *
     *  1. 3번의 select 과정에서 Exception이 발생하지 않아야 한다.
     *  2. 3개의 결과가 null이 아니어야 한다.
     */

    Member3_3 member1 = null;
    Member3_3 member2 = null;
    Member3_3 member3 = null;

    try {
      member1 = memberDao.selectById(member[0].getMemberId());
      member2 = memberDao.selectById(member[1].getMemberId());
      member3 = memberDao.selectById(member[2].getMemberId());
    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }

    if(equalsMember(member[0], member1) == true &&
        equalsMember(member[1], member2) == true &&
        equalsMember(member[2], member3) == true) {

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

    Member3_3 member1 = memberDao.selectById(member[0].getMemberId());
    Member3_3 member2 = memberDao.selectById(member[1].getMemberId());
    Member3_3 member3 = memberDao.selectById(member[2].getMemberId());

    if(equalsMember(member[0], member1) == true &&
        equalsMember(member[1], member2) == true &&
        equalsMember(member[2], member3) == true) {

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

  static boolean equalsMember(Member3_3 member1, Member3_3 member2) {

    if(member1 == null || member2 == null) {
      return false;
    }

    if((member1 instanceof Member3_3) == false) {
      return false;
    }
    if((member2 instanceof Member3_3) == false) {
      return false;
    }

    // 동일성 비교
    if(member1 == member2) {
      return true;
    }

    // 동등성 비교
    if(member1.getMemberNo() != member2.getMemberNo()) {
      return false;
    }
    if(member1.getMemberId().equals(member2.getMemberId()) == false) {
      return false;
    }
    if(member1.getMemberPw().equals(member2.getMemberPw()) == false) {
      return false;
    }
    if(member1.getName().equals(member2.getMemberPw()) == false) {
      return false;
    }
    if(member1.getStatus().equals(member2.getStatus()) == false) {
      return false;
    }
    if(member1.getRegisterDatetime().equals(member2.getRegisterDatetime()) == false) {
      return false;
    }

    return true;
  }
}
