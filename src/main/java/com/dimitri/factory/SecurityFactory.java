package com.dimitri.factory;

import com.dimitri.domain.Security;
import com.dimitri.util.IdGenerator;

public class SecurityFactory {
    public static Security getSecurity(String sName, String sLname, String sPhone, String sEmail){
        return new Security.Builder().securityId(IdGenerator.generateId())
                .securityName(sName)
                .securitySurname(sLname)
                .securityPhoneNr(sPhone)
                .securityEmail(sEmail)
                .build();
    }
}
