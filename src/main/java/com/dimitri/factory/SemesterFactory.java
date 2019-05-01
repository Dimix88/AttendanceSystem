package com.dimitri.factory;

import com.dimitri.domain.Semester;
import com.dimitri.util.IdGenerator;

public class SemesterFactory {
    public static Semester getSemester(String semYear, String semTerm, String semYr, String semSD, String semED){
        return new Semester.Builder().semesterCode(IdGenerator.generateId())
                .semesterYear(semYear)
                .semesterTerm(semYear)
                .semesterStartDate(semSD)
                .semesterEndDate(semED)
                .build();
    }
}
