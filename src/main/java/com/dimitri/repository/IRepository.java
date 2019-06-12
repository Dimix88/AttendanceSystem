package com.dimitri.repository;

public interface IRepository<T, ID> {
    T create(T item);
    T update(T item);
    void delete(ID id);
    T read(ID id);
}
