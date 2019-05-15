package com.dimitri.Repository;

import com.dimitri.domain.Cleaner;

import java.util.Set;

public interface CleanerRepository extends Repository<Cleaner,String> {
    Set<Cleaner> getAll();
}
