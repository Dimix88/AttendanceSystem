package com.dimitri.repository;

import com.dimitri.domain.CollegeTimetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableIRepository extends JpaRepository<CollegeTimetable, String> {
}
