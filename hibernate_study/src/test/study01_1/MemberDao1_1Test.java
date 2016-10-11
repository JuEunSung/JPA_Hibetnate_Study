package test.study01_1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import study.study01_1.HibernateUtil;
import study.study01_1.Member1_1;
import study.study01_1.MemberDao1_1;

/**
 * 전에 작성했던 study01를 리팩토링 했습니다.
 *
 *  관심 분리를 통해 DaoTemplate, HibernateUtil 가 추가되었으며,
 *
 *  DaoTemplate 에서 쿼리의 유형을 구분하기 위해 QueryType 열거형이 추가되었습니다.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberDao1_1Test {

  private static MemberDao1_1 memberDao;
  private static Member1_1 [] member = new Member1_1[3];

  @BeforeClass
  public static void before() {

    memberDao = new MemberDao1_1();

    member[0] = new Member1_1("lee", "123", "이순신", "1");
    member[1] = new Member1_1("hong", "456", "홍길동", "0");
    member[2] = new Member1_1("ju", "789", "주은성", "1");
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

    Member1_1 member1 = null;
    Member1_1 member2 = null;
    Member1_1 member3 = null;

    try {
      member1 = memberDao.selectById(member[0].getMemberId());
      member2 = memberDao.selectById(member[1].getMemberId());
      member3 = memberDao.selectById(member[2].getMemberId());
    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }

    if(member1 == null || member2 == null || member3 == null) {
      assertTrue(false);
    }

    System.out.println(member1);
    System.out.println(member2);
    System.out.println(member3);

    assertTrue(true);
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
      member[0] = memberDao.selectById(member[0].getMemberId());
      member[1] = memberDao.selectById(member[1].getMemberId());
      member[2] = memberDao.selectById(member[2].getMemberId());

      System.out.println(member[0]);
      System.out.println(member[1]);
      System.out.println(member[2]);

      member[0].setStatus("999");
      member[1].setStatus("999");
      member[2].setStatus("999");

      memberDao.update(member[0]);
      memberDao.update(member[1]);
      memberDao.update(member[2]);
    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }

    Member1_1 member1 = memberDao.selectById(member[0].getMemberId());
    Member1_1 member2 = memberDao.selectById(member[1].getMemberId());
    Member1_1 member3 = memberDao.selectById(member[2].getMemberId());

    boolean flag = false;
    if(member[0].getStatus().equals(member1.getStatus()) &&
        member[1].getStatus().equals(member2.getStatus()) &&
        member[2].getStatus().equals(member3.getStatus())) {

      flag = true;
    }

    if(flag == true) {
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
}
