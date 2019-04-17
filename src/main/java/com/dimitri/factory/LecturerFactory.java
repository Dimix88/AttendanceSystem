package com.dimitri.factory;

import com.dimitri.domain.Lecturer;
import com.dimitri.util.IdGenerator;

public class LecturerFactory {

    public static Lecturer getLecturer(String name, String sName, String phone, String lecEmail){

        return new Lecturer.Builder().lecId(IdGenerator.generateId())
                .firstName(name)
                .surname(sName)
                .phoneNumber(phone)
                .email(lecEmail)
                .build();

    }
}
