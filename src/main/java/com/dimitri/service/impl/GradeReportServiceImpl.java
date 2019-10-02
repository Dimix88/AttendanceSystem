package com.dimitri.service.impl;

import com.dimitri.repository.GradeReportIRepository;
//import com.dimitri.repository.impl.GradeReportIRepositoryImpl;
import com.dimitri.domain.GradeReport;
import com.dimitri.service.GradeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("GradeReportServiceImpl")
public class GradeReportServiceImpl implements GradeReportService {
    public static GradeReportService gradeReportService=null;

    @Autowired
    private GradeReportIRepository repository;

    private GradeReportServiceImpl(){}

    public static GradeReportService getGradeReportService(){
        if (gradeReportService==null)gradeReportService = new GradeReportServiceImpl();
        return gradeReportService;
    }
    @Override
    public List<GradeReport> getAll() {
        return this.repository.findAll();
    }

    @Override
    public GradeReport create(GradeReport gradeReport) {
        return this.repository.save(gradeReport);
    }

    @Override
    public GradeReport update(GradeReport gradeReport) {
        return this.repository.save(gradeReport);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public GradeReport read(String s) {
        Optional<GradeReport>optionalGradeReport = this.repository.findById(s);
        return optionalGradeReport.orElse(null);
    }
}
