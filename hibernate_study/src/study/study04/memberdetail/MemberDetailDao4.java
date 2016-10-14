package study.study04.memberdetail;

import study.study04.util.DaoTemplate;

public class MemberDetailDao4 {

  private DaoTemplate<MemberDetail4> getDaoTemplate() {

    return new DaoTemplate<MemberDetail4>();
  }

  public void insert(MemberDetail4 memberDetail) throws Exception {

    getDaoTemplate().insert(memberDetail);
  }

  public MemberDetail4 selectByMemberNo(int memberNo) throws Exception {

    String query = "SELECT md FROM MemberDetail4 md WHERE md.member.memberNo = " + memberNo;

    return getDaoTemplate().selectQuery(query);
  }

  public void update(MemberDetail4 memberDetail) throws Exception {

    getDaoTemplate().update(memberDetail);
  }

  public void delete(MemberDetail4 memberDetail) throws Exception {

    getDaoTemplate().delete(memberDetail);
  }
}
