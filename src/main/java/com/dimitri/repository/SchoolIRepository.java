package com.dimitri.repository;

import com.dimitri.domain.School;
import com.dimitri.repository.IRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

public interface SchoolIRepository extends IRepository<School, String> {
    Set<School> getAll();
}
