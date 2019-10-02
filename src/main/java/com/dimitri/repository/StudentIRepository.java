package com.dimitri.repository;

import com.dimitri.domain.Student;
import java.util.Set;
import com.dimitri.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentIRepository extends JpaRepository<Student, String> {
}
