package com.dimitri.repository;

import com.dimitri.domain.Semester;
import com.dimitri.repository.IRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

public interface SemesterIRepository extends IRepository<Semester, String> {
    Set<Semester>getAll();
}
