package com.aug.banking.service;

import java.util.List;

/**
 * @author AUG-augustin.rakotoarivelo@orange.com
 */
public interface AbstractService <T> {
    Integer save(T dto);
    List<T> findAll();
    T findById(Integer id);
    void delete(Integer id);
}
