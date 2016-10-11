package study.study03_3.member;

import java.util.List;

import study.study03_3.util.DaoTemplate;

public class MemberDao3_3 {

  private DaoTemplate<Member3_3> getDaoTemplate() {

    return new DaoTemplate<Member3_3>();
  }

  public void insert(Member3_3 member) throws Exception {

    getDaoTemplate().insert(member);
  }

  public Member3_3 selectById(String memberId) throws Exception {

    String query = "SELECT m FROM Member3_3 m WHERE m.memberId = '" + memberId + "'";

    return getDaoTemplate().selectQuery(query);
  }

  public long selectCount() throws Exception {

    return new DaoTemplate<Long>().selectQuery("SELECT COUNT(m) FROM Member3_3 m");
  }

  public List<Member3_3> selectList() throws Exception {

    return getDaoTemplate().selectListQuery("SELECT m FROM Member3_3 m");
  }

  public void delete(Member3_3 member) throws Exception {

    getDaoTemplate().delete(member);
  }

  public void update(Member3_3 member) throws Exception {

    getDaoTemplate().update(member);
  }

}
