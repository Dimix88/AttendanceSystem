package com.dimitri.service.impl;

import com.dimitri.Repository.GradeReportRepository;
import com.dimitri.Repository.impl.GradeReportRepositoryImpl;
import com.dimitri.domain.GradeReport;
import com.dimitri.service.GradeReportService;

import java.util.Set;

public class GradeReportServiceImpl implements GradeReportService {
    private static GradeReportServiceImpl service = null;
    private GradeReportRepository repository = null;

    private GradeReportServiceImpl(){
        this.repository = GradeReportRepositoryImpl.getRepository();
    }
    public static GradeReportServiceImpl getService(){
        if(service == null) service = new GradeReportServiceImpl();
        return service;
    }
    @Override
    public Set<GradeReport> getAll() {
        return this.repository.getAll();
    }

    @Override
    public GradeReport create(GradeReport gradeReport) {
        return this.repository.create(gradeReport);
    }

    @Override
    public GradeReport update(GradeReport gradeReport) {
        return this.repository.update(gradeReport);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public GradeReport read(String s) {
        return this.repository.read(s);
    }
}
