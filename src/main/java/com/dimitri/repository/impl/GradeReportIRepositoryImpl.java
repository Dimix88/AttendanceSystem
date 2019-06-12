package com.dimitri.repository.impl;

import com.dimitri.repository.GradeReportIRepository;
import com.dimitri.domain.GradeReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Repository("GradeReportRepository")
public class GradeReportIRepositoryImpl implements GradeReportIRepository {
    @Autowired
    private static GradeReportIRepositoryImpl repository = null;
    private Set<GradeReport> gradeReports;

    private GradeReportIRepositoryImpl(){
        this.gradeReports = new HashSet<>();
    }

    private GradeReport findGradeReport(String studentID){
        for (GradeReport classes2: this.gradeReports){
            if (classes2.getStudentID().equals(studentID))
                return classes2;
        }
        return null;    }
    public static GradeReportIRepository getRepository(){
        if(repository == null) repository = new GradeReportIRepositoryImpl();
        return repository;
    }
    @Override
    public GradeReport create(GradeReport gradeReport) {
        this.gradeReports.add(gradeReport);
        return gradeReport;
    }

    @Override
    public GradeReport update(GradeReport gradeReport) {
        GradeReport toDelete = findGradeReport(gradeReport.getStudentID());
        if(toDelete != null) {
            this.gradeReports.remove(toDelete);
            return create(gradeReport);
        }
        return null;
    }

    @Override
    public void delete(String studentID) {
        GradeReport class1 = findGradeReport(studentID);
        if(class1 != null){
            this.gradeReports.remove(class1);
        }    }

    @Override
    public GradeReport read(String studentID) {
        return findGradeReport(studentID);
    }
    public Set<GradeReport> getAll(){
        return this.gradeReports;
    }
}
