package study.study04.member;

import java.util.List;

import study.study04.util.DaoTemplate;
import study.study04.util.UpdateDaoTemplate;

public class MemberDao4 extends UpdateDaoTemplate<Member4> {

  public Member4 selectById(String memberId) throws Exception {

    String query = "SELECT m FROM Member4 m WHERE m.memberId = '" + memberId + "'";

    return getDaoTemplate().selectQuery(query);
  }

  public long selectCount() throws Exception {

    return new DaoTemplate<Long>().selectQuery("SELECT COUNT(m) FROM Member4 m");
  }

  public List<Member4> selectList() throws Exception {

    return getDaoTemplate().selectListQuery("SELECT m FROM Member4 m");
  }

}
