package com.dimitri.Repository.impl;

import com.dimitri.Repository.GradeReportRepository;
import com.dimitri.domain.GradeReport;

import java.util.HashSet;
import java.util.Set;

public class GradeReportRepositoryImpl implements GradeReportRepository {
    private static GradeReportRepositoryImpl repository = null;
    private Set<GradeReport> gradeReports;

    private GradeReportRepositoryImpl(){
        this.gradeReports = new HashSet<>();
    }

    private GradeReport findGradeReport(String studentID){
        for (GradeReport classes2: this.gradeReports){
            if (classes2.getStudentID().equals(studentID))
                return classes2;
        }
        return null;    }
    public static GradeReportRepository getRepository(){
        if(repository == null) repository = new GradeReportRepositoryImpl();
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
