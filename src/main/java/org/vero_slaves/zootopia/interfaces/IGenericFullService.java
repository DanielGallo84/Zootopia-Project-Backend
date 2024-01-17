package org.vero_slaves.zootopia.interfaces;

import java.util.List;

import org.vero_slaves.zootopia.messages.Message;

public interface IGenericFullService<T> {
    public List<T> getAll();
    public T getById(Long id) throws Exception;
    public T getByName(String name) throws Exception;
    public T save(T obj);
    public T update(Long id, T obj) throws Exception;
    public Message delete (Long id) throws Exception;
}
