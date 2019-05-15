package com.dimitri.Repository;

import com.dimitri.domain.Name;

import java.util.Set;

public interface NameRepository extends Repository<Name, String> {
    Set<Name>getAll();
}
