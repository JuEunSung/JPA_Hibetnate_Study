package study.study03;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

  private static EntityManagerFactory emf;
  private static EntityManager em;

  private static final String PERSISTENCE_UNIT_NAME = "study";

  static {
    emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    em = emf.createEntityManager();
  }

  public static EntityManagerFactory getEntityManagerFactory() {

    return emf;
  }

  public static EntityManager getEntityManager() {

    return em;
  }

  public static void shutdown() {

    em.close();
    emf.close();
  }
}
