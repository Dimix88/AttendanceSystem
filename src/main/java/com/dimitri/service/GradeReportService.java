package com.dimitri.service;

import com.dimitri.domain.GradeReport;

import java.util.Set;

public interface GradeReportService extends IService<GradeReport, String> {
    Set<GradeReport>getAll();
}
