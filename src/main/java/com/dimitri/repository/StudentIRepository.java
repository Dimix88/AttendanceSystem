package com.dimitri.repository;

import com.dimitri.domain.Student;
import java.util.Set;
import com.dimitri.repository.IRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface StudentIRepository extends IRepository <Student, String> {
    Set<Student>getAll();
}
