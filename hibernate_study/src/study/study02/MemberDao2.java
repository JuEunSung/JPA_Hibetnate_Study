package study.study02;

import java.util.List;

public class MemberDao2 {

  private DaoTemplate<Member2> getDaoTemplate() {

    return new DaoTemplate<Member2>();
  }

  public void insert(Member2 member) throws Exception {

    getDaoTemplate().insert(member);
  }

  public Member2 selectById(String memberId) throws Exception {

    String query = "SELECT m FROM Member2 m WHERE m.memberId = '" + memberId + "'";

    return getDaoTemplate().selectQuery(query);
  }

  public long selectCount() throws Exception {

    return new DaoTemplate<Long>().selectQuery("SELECT COUNT(m) FROM Member2 m");
  }

  public List<Member2> selectList() throws Exception {

    return getDaoTemplate().selectListQuery("SELECT m FROM Member2 m");
  }

  public void delete(Member2 member) throws Exception {

    getDaoTemplate().delete(member);
  }

  public void update(Member2 member) throws Exception {

    getDaoTemplate().update(member);
  }

}
