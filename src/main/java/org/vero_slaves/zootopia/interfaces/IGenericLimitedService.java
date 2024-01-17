package org.vero_slaves.zootopia.interfaces;

import java.util.List;

public interface IGenericLimitedService<T> {
    public List<T> getAll();
    public T getById(Long id) throws Exception;
    public T save(T obj);
}
