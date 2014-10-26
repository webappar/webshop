package com.project.webshop.service;

import java.io.Serializable;
import java.util.List;

/**
 * Interface defining the CRUD Operations
 *
 * @param <T> type of elements in container
 * @param <K> K is type of id (primary key)
 */
public interface IGenericDAO<T, K extends Serializable> {

    public void save(T entity);

    public void update(T entity);

    public void delete(T id);

    public T find(Class<T> clazz, K id);

    public List<T> findAll(Class<T> clazz);

    public List<T> findRange(Class<T> clazz, int fst, int count);

    public int count(Class<T> clazz);
}
