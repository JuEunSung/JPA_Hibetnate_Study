package test.study01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import study.study01.Member1;
import study.study01.MemberDao1;

/**
 * EnityManager를 테스트하기 위한 코드 입니다.
 *
 *  CRUD와 Query를 직접 작성해보고 결과를 확인하도록 합니다.
 *
 *  테스트 순서는 이름순으로 시작됩니다.
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberDao1Test {

  private MemberDao1 memberDao;
  private Member1 [] member = new Member1[3];

  @Before
  public void before() {

    memberDao = new MemberDao1();

    member[0] = new Member1("lee", "123", "이순신", "1");
    member[1] = new Member1("hong", "456", "홍길동", "0");
    member[2] = new Member1("ju", "789", "주은성", "1");
  }

  @After
  public void after() {

    memberDao.emf.close();
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

    Member1 member1 = null;
    Member1 member2 = null;
    Member1 member3 = null;

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
  public void test3update() {

    /*
     * 테스트 조건
     *
     *  1. 3번의 update 과정에서 Exception이 발생하지 않아야 한다.
     *  2. 데이터베이스에서 3개의 Member를 조회하고 값이 같은지 비교한다.
     */

    try {
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

    Member1 member1 = memberDao.selectById(member[0].getMemberId());
    Member1 member2 = memberDao.selectById(member[1].getMemberId());
    Member1 member3 = memberDao.selectById(member[2].getMemberId());

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
  public void test4delete() {

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
