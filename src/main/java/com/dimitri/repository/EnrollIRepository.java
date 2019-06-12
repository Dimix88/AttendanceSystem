package com.dimitri.repository;

import com.dimitri.domain.Enroll;
import com.dimitri.repository.IRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

public interface EnrollIRepository extends IRepository<Enroll, String> {
    Set<Enroll>getAll();
}
