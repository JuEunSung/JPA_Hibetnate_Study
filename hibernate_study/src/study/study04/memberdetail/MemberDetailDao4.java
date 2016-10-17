package study.study04.memberdetail;

import study.study04.util.UpdateDaoTemplate;

public class MemberDetailDao4 extends UpdateDaoTemplate<MemberDetail4> {

  public MemberDetail4 selectByMemberNo(int memberNo) throws Exception {

    String query = "SELECT md FROM MemberDetail4 md WHERE md.member.memberNo = " + memberNo;

    return getDaoTemplate().selectQuery(query);
  }
}
