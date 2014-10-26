package com.project.webshop.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Abstract class implementing all CRUD operations.
 *
 * @param <T> type of elements in container
 * @param <K> K is type of id (primary key)
 */
public abstract class GenericDAO<T, K extends Serializable> implements IGenericDAO<T, K> {

    final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    public void save(T entity) {
        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            HibernateUtil.getSessionFactory().getCurrentSession().close();
        }
    }

    public void update(T entity) {
        try {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            HibernateUtil.getSessionFactory().getCurrentSession().close();
        }
    }

    public void delete(T id) {
        try {
            session.beginTransaction();
            session.delete(id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            HibernateUtil.getSessionFactory().getCurrentSession().close();
        }
    }

    public T find(Class<T> clazz, K id) {
        T obj = null;
        try {
            session.beginTransaction();
            obj = (T) session.get(clazz, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            HibernateUtil.getSessionFactory().getCurrentSession().close();
        }
        return obj;
    }

    public List<T> findAll(Class<T> clazz) {
        List<T> objects = null;
        try {
            session.beginTransaction();
            objects = session.createQuery("from " + clazz.getName()).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            HibernateUtil.getSessionFactory().getCurrentSession().close();
        }
        return objects;
    }

    public List<T> findRange(Class<T> clazz, int fst, int count) {
        List<T> objects = null;
        try {
            session.beginTransaction();
            objects = session.createQuery("from " + clazz.getName()).setFirstResult(fst).setMaxResults(count).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            HibernateUtil.getSessionFactory().getCurrentSession().close();
        }
        return objects;
    }

    public int count(Class<T> clazz) {
        int c = -1;
        try {
            session.beginTransaction();
            c = ((Long)session.createQuery("select count(*) from " + clazz.getName()).uniqueResult()).intValue();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            HibernateUtil.getSessionFactory().getCurrentSession().close();
        }
        return c;
    }
}
