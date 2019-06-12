package com.dimitri.repository;

import com.dimitri.domain.GradeReport;
import com.dimitri.repository.IRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

public interface GradeReportIRepository extends IRepository<GradeReport, String> {
    Set<GradeReport>getAll();
}
