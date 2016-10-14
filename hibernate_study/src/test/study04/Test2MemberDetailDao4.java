package test.study04;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import study.study04.member.Member4;
import study.study04.member.MemberDao4;
import study.study04.member.MemberStatus;
import study.study04.memberdetail.MemberDetail4;
import study.study04.memberdetail.MemberDetailDao4;
import study.study04.util.HibernateUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test2MemberDetailDao4 {

  private static MemberDao4 memberDao;
  private static MemberDetailDao4 memberDetailDao;

  private static Member4 [] member = new Member4[3];
  private static MemberDetail4 [] memberDetail = new MemberDetail4[3];

  @BeforeClass
  public static void beforClass() {

    memberDao = new MemberDao4();
    memberDetailDao = new MemberDetailDao4();

    member[0] = new Member4("lee", "123", "이순신", MemberStatus.ACTIVATE);
    member[1] = new Member4("hong", "456", "홍길동", MemberStatus.WITHDRAWAL);
    member[2] = new Member4("ju", "789", "주은성", MemberStatus.ACTIVATE);

    memberDetail[0] = new MemberDetail4("010-1111-1111", "wndmstjd90@naver.com");
    memberDetail[1] = new MemberDetail4("010-2222-2222", "wndmstjd90@gmail.com");
    memberDetail[2] = new MemberDetail4("010-3333-3333", "wndmstjd90@nate.com");

    Test1MemberDao4.insertMembers(memberDao, member);
  }

  @AfterClass
  public static void afterClass() {

    try {

      Test1MemberDao4.deleteMembers(memberDao, member);

    } catch (Exception e) {
      e.printStackTrace();
    }

    HibernateUtil.shutdown();
  }

  @Test
  public void test1insert() {

    try {
      memberDetail[0].setMember(member[0]);
      memberDetail[1].setMember(member[1]);
      memberDetail[2].setMember(member[2]);

      memberDetailDao.insert(memberDetail[0]);
      memberDetailDao.insert(memberDetail[1]);
      memberDetailDao.insert(memberDetail[2]);
    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }

    assertTrue(true);
  }

  @Test
  public void test2select() {

    boolean result = false;

    try {
      MemberDetail4 memberDetail1 = memberDetailDao.selectByMemberNo(member[0].getMemberNo());
      MemberDetail4 memberDetail2 = memberDetailDao.selectByMemberNo(member[1].getMemberNo());
      MemberDetail4 memberDetail3 = memberDetailDao.selectByMemberNo(member[2].getMemberNo());

      if(memberDetail[0].equals(memberDetail1) == true &&
          memberDetail[1].equals(memberDetail2) == true &&
          memberDetail[2].equals(memberDetail3) == true) {

        result = true;
      }
    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }

    if(result == true) {
      assertTrue(true);
    } else {
      assertTrue(false);
    }
  }

  @Test
  public void test3update() {

    try {
      memberDetail[0].setPhoneNumber("010-4444-4444");
      memberDetail[1].setPhoneNumber("010-5555-5555");
      memberDetail[2].setPhoneNumber("010-6666-6666");

      memberDetailDao.update(memberDetail[0]);
      memberDetailDao.update(memberDetail[1]);
      memberDetailDao.update(memberDetail[2]);
    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }

    assertTrue(true);
  }

  @Test
  public void test4delete() {

    try {
      memberDetailDao.delete(memberDetail[0]);
      memberDetailDao.delete(memberDetail[1]);
      memberDetailDao.delete(memberDetail[2]);
    } catch(Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }
  }
}
