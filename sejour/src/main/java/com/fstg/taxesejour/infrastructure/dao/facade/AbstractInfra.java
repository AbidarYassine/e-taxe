package com.fstg.taxesejour.infrastructure.dao.facade;

import java.util.List;

public interface AbstractInfra<T> {
    T save(T entity);
    List<T> findAll();
}
