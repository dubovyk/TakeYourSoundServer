package com.dubovyk.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * @author Sergey Dubovyk aka knidarkness
 * @version 1.0
 */
public abstract class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK> {
    protected final CrudRepository<T, PK> dao;

    @Autowired
    public GenericServiceImpl(CrudRepository<T, PK> dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void save(T t){
        dao.save(t);
    }

    @Override
    @Transactional
    public void delete(T t){
        dao.delete(t);
    }

    @Override
    @Transactional
    public void update(T t){
        dao.save(t);
    }

    @Override
    @Transactional
    public void deleteById(PK id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public List<T> findAll() {
        return (List<T>) dao.findAll();
    }

    @Override
    @Transactional
    public T findById(PK id) {
        return dao.findOne(id);
    }
}
