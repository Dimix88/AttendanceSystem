package com.dimitri.repository;

import com.dimitri.domain.Classes;
import com.dimitri.repository.IRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

public interface ClassesIRepository extends IRepository<Classes, String> {
    Set<Classes>getAll();
}
