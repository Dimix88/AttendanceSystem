package com.dimitri.Repository;

import com.dimitri.domain.Student;

public interface Repository<T, ID> {
    T create(T item);
    T update(T item);
    void delete(ID id);
    T read(ID id);
}
