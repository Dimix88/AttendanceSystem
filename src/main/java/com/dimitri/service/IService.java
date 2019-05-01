package com.dimitri.service;

public interface IService<T, ID> {
    T create(T item);
    T update(T item);
    void delete(ID id);
    T read(ID id);
}
