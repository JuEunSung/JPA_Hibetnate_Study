package study.study04.member;

import java.util.List;

import study.study04.util.DaoTemplate;

public class MemberDao4 {

  private DaoTemplate<Member4> getDaoTemplate() {

    return new DaoTemplate<Member4>();
  }

  public void insert(Member4 member) throws Exception {

    getDaoTemplate().insert(member);
  }

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

  public void delete(Member4 member) throws Exception {

    getDaoTemplate().delete(member);
  }

  public void update(Member4 member) throws Exception {

    getDaoTemplate().update(member);
  }

}
