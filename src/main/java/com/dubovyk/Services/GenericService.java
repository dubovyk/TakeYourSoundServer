package com.dubovyk.Services;

import java.io.Serializable;
import java.util.List;

/**
 * @author Sergey Dubovyk aka knidarkness
 * @version 1.0
 */
public interface GenericService<T, PK extends Serializable> {
    void save(T t);
    void update(T t);
    void delete(T t);
    void deleteById(PK id);
    List<T> findAll();
    T findById(PK id);
}
