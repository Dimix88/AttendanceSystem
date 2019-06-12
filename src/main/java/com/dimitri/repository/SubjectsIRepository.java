package com.dimitri.repository;

import com.dimitri.domain.Subjects;
import com.dimitri.repository.IRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

public interface SubjectsIRepository extends IRepository<Subjects, String> {
    Set<Subjects>getAll();
}
