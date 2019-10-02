package com.dimitri.factory;

import com.dimitri.domain.Name;
import com.dimitri.util.IdGenerator;

public class NameFactory {

    public static Name getName(String fName, String mName, String lName){
        return new Name.Builder().nameCode(IdGenerator.generateId())
                .firstName(fName)
                .middleName(mName)
                .lastName(lName)
                .build();

    }
}
