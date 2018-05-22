package com.winterShop.service.contracts;

import java.io.Serializable;
import java.util.List;


public interface AbstractService<T, ID> {

    List<T> getAll();

    T getById(ID id);

    T save(T entity);

    T update(T entity);

    void delete(ID id);
}
