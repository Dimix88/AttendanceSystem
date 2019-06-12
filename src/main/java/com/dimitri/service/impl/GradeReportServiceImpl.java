package com.dimitri.service.impl;

import com.dimitri.repository.GradeReportIRepository;
import com.dimitri.repository.impl.GradeReportIRepositoryImpl;
import com.dimitri.domain.GradeReport;
import com.dimitri.service.GradeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("ServiceImpl8")
public class GradeReportServiceImpl implements GradeReportService {
    @Autowired
    @Qualifier("GradeReportRepository")
    private static GradeReportServiceImpl service = null;
    private GradeReportIRepository repository = null;

    private GradeReportServiceImpl(){
        this.repository = GradeReportIRepositoryImpl.getRepository();
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
