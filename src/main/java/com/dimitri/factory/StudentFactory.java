package com.dimitri.factory;

import com.dimitri.domain.Course;
import com.dimitri.domain.Student;
import com.dimitri.util.IdGenerator;

import java.util.Set;

public class StudentFactory {

    public static Student getStudent(String firstName, String surname, String phone, String email){

        return new Student.Builder().studentId(IdGenerator.generateId())
                .studentName(firstName)
                .studentSurname(surname)
                .studentPhoneNr(phone)
                .studentEmail(email)
                .build();

    }

}
