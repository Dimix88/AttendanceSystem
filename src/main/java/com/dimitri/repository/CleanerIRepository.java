package com.dimitri.repository;

import com.dimitri.domain.Cleaner;
import com.dimitri.repository.IRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

public interface CleanerIRepository extends IRepository<Cleaner,String> {
    Set<Cleaner> getAll();
}
