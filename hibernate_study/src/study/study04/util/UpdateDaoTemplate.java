package study.study04.util;

public class UpdateDaoTemplate <T> extends DaoTemplate<T> {

  protected DaoTemplate<T> getDaoTemplate() {

    return new DaoTemplate<T>();
  }

  public void insert(T t) throws Exception {

    getDaoTemplate().insert(t);
  }

  public void update(T t) throws Exception {

    getDaoTemplate().update(t);
  }

  public void delete(T t) throws Exception {

    getDaoTemplate().delete(t);
  }

}
