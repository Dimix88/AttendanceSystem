package com.dimitri.factory;

import com.dimitri.domain.Department;
import com.dimitri.util.IdGenerator;

public class DepartmentFactory {
    public static Department getDepartment(String dName, String sName){
        return new Department.Builder().deptCode(IdGenerator.generateId())
                .deptName(dName)
                .schoolName(sName)
                .lecId(IdGenerator.generateId())
                .build();
    }
}
