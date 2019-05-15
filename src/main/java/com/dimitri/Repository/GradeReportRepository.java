package com.dimitri.Repository;

import com.dimitri.domain.GradeReport;

import java.util.Set;

public interface GradeReportRepository extends Repository<GradeReport, String> {
    Set<GradeReport>getAll();
}
