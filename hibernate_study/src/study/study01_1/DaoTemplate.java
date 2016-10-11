package study.study01_1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class DaoTemplate <T> {

  public void insert(T t) throws Exception {

    updateQuery(QueryType.INSERT, t);
  }

  public void update(T t) throws Exception {

    updateQuery(QueryType.UPDATE, t);
  }

  public void delete(T t) throws Exception {

    updateQuery(QueryType.DELETE, t);
  }

  public T selectQuery(String query) throws Exception {

    Query q = getQuery(query);

    return (T) q.getSingleResult();
  }

  public List<T> selectListQuery(String query) throws Exception {

    Query q = getQuery(query);

    return (List<T>) q.getResultList();
  }

  private void updateQuery(QueryType type, T t) throws Exception {

    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();

    if(type.equals(QueryType.INSERT)) {

      em.persist(t);

    } else if(type.equals(QueryType.UPDATE)) {

      em.merge(t);

    } else if(type.equals(QueryType.DELETE)) {

      em.remove(t);
    }

    tx.commit();
  }

  private EntityManager getEntityManager() throws Exception {

    return HibernateUtil.getEntityManager();
  }

  private Query getQuery(String query) throws Exception {

    return getEntityManager().createQuery(query);
  }
}