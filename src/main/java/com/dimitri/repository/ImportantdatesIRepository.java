package com.dimitri.repository;

import com.dimitri.domain.ImportantDates;
import com.dimitri.repository.IRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

public interface ImportantdatesIRepository extends IRepository<ImportantDates, String> {
    Set<ImportantDates>getAll();
}
