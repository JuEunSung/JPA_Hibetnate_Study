package study.study01_1;

import java.util.List;

public class MemberDao1_1 {

  /*
   * 관심사 분리 ::
   *
   *   공통
   *   - getEntityManager()
   *
   *   insert / update / delete
   *   - em.getTransaction()
   *   - begin / logic / commit
   *
   *   select
   *   - Query 생성
   *   - getResultList() or getSingleResult()
   */

  private DaoTemplate<Member1_1> getDaoTemplate() {

    return new DaoTemplate<Member1_1>();
  }

  public void insert(Member1_1 member) throws Exception {

    getDaoTemplate().insert(member);
  }

  public Member1_1 selectById(String memberId) throws Exception {

    String query = "SELECT m FROM Member1_1 m WHERE m.memberId = '" + memberId + "'";

    return getDaoTemplate().selectQuery(query);
  }

  public long selectCount() throws Exception {

    return new DaoTemplate<Long>().selectQuery("SELECT COUNT(m) FROM Member1_1 m");
  }

  public List<Member1_1> selectList() throws Exception {

    return getDaoTemplate().selectListQuery("SELECT m FROM Member1_1 m");
  }

  public void delete(Member1_1 member) throws Exception {

    getDaoTemplate().delete(member);
  }

  public void update(Member1_1 member) throws Exception {

    getDaoTemplate().update(member);
  }

}
