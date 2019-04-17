package com.dimitri.factory;

import com.dimitri.domain.Name;

public class NameFactory {

    public static Name getName(String fName, String mName, String lName){
        return new Name.Builder().firstName(fName)
                .middleName(mName)
                .lastName(lName)
                .build();

    }
}
