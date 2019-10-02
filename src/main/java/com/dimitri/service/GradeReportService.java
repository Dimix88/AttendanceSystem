package com.dimitri.service;

import com.dimitri.domain.GradeReport;

import java.util.List;

public interface GradeReportService extends IService<GradeReport, String> {
    List<GradeReport> getAll();
}
