package com.dimitri.repository;

import com.dimitri.domain.CollegeSubjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectsIRepository extends JpaRepository<CollegeSubjects, String> {
}
