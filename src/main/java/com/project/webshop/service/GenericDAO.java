package com.project.webshop.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public abstract class GenericDAO<T, K extends Serializable> implements IGenericDAO<T, K> {

    final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    public void saveOrUpdate(T entity) {
        try {
            session.beginTransaction();
            session.saveOrUpdate(entity);
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
            Query query = session.createQuery("from " + clazz.getName());
            objects = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            HibernateUtil.getSessionFactory().getCurrentSession().close();
        }
        return objects;
    }
}
