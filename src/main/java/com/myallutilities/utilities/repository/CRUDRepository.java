package com.myallutilities.utilities.repository;

import java.util.List;

public interface CRUDRepository<T, ID> {

    T findById(ID id);

    List<T> findAll();

    void saveOrUpdate(T entity);

}
