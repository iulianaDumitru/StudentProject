package model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class GenericDao<T> {


    private static GenericDao genericDao;
    private SessionFactory sessionFactory;

    public GenericDao(){
        GenericDaoSingleton genericDaoSingleton =
                GenericDaoSingleton.getInstance();
        sessionFactory = genericDaoSingleton.getSessionFactory();
    }


    public void add(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        if (session != null) {
            session.close();
        }
    }

    public void update(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();

        if (session != null) {
            session.close();
        }
    }

    public List<T> getAll(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from " + object.getClass().getName());

        List<T> result = query.getResultList();
        transaction.commit();

        if (session != null) {
            session.close();
        }

        return result;
    }

    public void delete(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();

        if (session != null) {
            session.close();
        }
    }

    public T findById(T object, int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from " + object.getClass().getName() + "" +
                " where id= " + id + "");
        T result = (T) query.getSingleResult();
        transaction.commit();

        if (session != null) {
            session.close();
        }
        return result;
    }

    public List<T> findByColumn(T object, String column, String value) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from " + object.getClass().getName() +
                "where" + column + " = '" + value + "'");
        List<T> result = query.getResultList();
        return result;
    }

    public void deleteByColumn(T object, String firstName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int result = session.createQuery("delete from " + object.getClass().getName() +
                " where firstName='" + firstName + "'").executeUpdate();
        transaction.commit();
    }

    public void updateByColumn(T object, String firstName, String lastName) {

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        int result = session.createQuery("update " + object.getClass().getName() +

                " set lastName='" + lastName + "' where firstName='" + firstName + "'").executeUpdate();

        transaction.commit();

    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
