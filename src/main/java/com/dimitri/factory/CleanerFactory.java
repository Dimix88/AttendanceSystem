package com.dimitri.factory;

import com.dimitri.domain.Cleaner;
import com.dimitri.domain.ImportantDates;
import com.dimitri.util.IdGenerator;

public class CleanerFactory {
    public static Cleaner getCleaner(String cName, String cLname, String cPhone, String cEmail){
        return new Cleaner.Builder().cleanerId(IdGenerator.generateId())
                .cleanerName(cName)
                .cleanerSurname(cLname)
                .cleanerPhoneNr(cPhone)
                .cleanerEmail(cEmail)
                .build();
    }
}
