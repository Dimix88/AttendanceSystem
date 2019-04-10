package com.dimitri.factory;

import com.dimitri.domain.Student;

public class StudentFactory {

    public static Student getStudent(String studentId, String studentName, String studentSurname){

        return new Student.Builder().studentId(studentId)
                .studentName(studentName)
                .StudentSurname(studentSurname)
                .build();

    }

}
