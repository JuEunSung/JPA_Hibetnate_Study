package study.study01;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MemberDao1 {

  public EntityManagerFactory emf;
  public EntityManager em;

  public MemberDao1() {
    emf = Persistence.createEntityManagerFactory("study");
    em = emf.createEntityManager();
  }

  public void insert(Member1 member) {

    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.persist(member);
    tx.commit();
  }

  public Member1 select(int memberNo) {

    return em.find(Member1.class, memberNo);
  }

  public Member1 selectById(String memberId) {

    Query query = em.createQuery("SELECT m FROM Member1 m WHERE m.memberId = '" + memberId + "'");

    return (Member1) query.getSingleResult();
  }

  public long selectCount() {

    Query query = em.createQuery("SELECT COUNT(m) FROM Member1 m");

    return (long) query.getSingleResult();
  }

  public List<Member1> selectList() {

    Query query = em.createQuery("SELECT m FROM Member1 m");
    List<Member1> memberList = query.getResultList();

    return memberList;
  }

  public void delete(Member1 member) {

    member = selectById(member.getMemberId());

    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.remove(member);
    tx.commit();
  }

  public void update(Member1 after) {

    Member1 before = selectById(after.getMemberId());

    EntityTransaction tx = em.getTransaction();
    tx.begin();
    before.setName(after.getName());
    before.setStatus(after.getStatus());
    tx.commit();
  }

}
