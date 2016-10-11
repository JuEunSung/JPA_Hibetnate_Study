package study.study03;

import java.util.List;

public class MemberDao3 {

  private DaoTemplate<Member3> getDaoTemplate() {

    return new DaoTemplate<Member3>();
  }

  public void insert(Member3 member) throws Exception {

    getDaoTemplate().insert(member);
  }

  public Member3 selectById(String memberId) throws Exception {

    String query = "SELECT m FROM Member3 m WHERE m.memberId = '" + memberId + "'";

    return getDaoTemplate().selectQuery(query);
  }

  public long selectCount() throws Exception {

    return new DaoTemplate<Long>().selectQuery("SELECT COUNT(m) FROM Member3 m");
  }

  public List<Member3> selectList() throws Exception {

    return getDaoTemplate().selectListQuery("SELECT m FROM Member3 m");
  }

  public void delete(Member3 member) throws Exception {

    getDaoTemplate().delete(member);
  }

  public void update(Member3 member) throws Exception {

    getDaoTemplate().update(member);
  }

}
