package com.dimitri.factory;

import com.dimitri.domain.GradeReport;
import com.dimitri.util.IdGenerator;

public class GradeReportFactory {
    public static GradeReport getGradeReport(String gLetter, String nGrade){
        return new GradeReport.Builder().studentID(IdGenerator.generateId())
                .gradeLetter(gLetter)
                .numericGrade(nGrade)
                .build();
    }
}
