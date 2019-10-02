package com.dimitri.factory;

import com.dimitri.domain.ImportantDates;
import com.dimitri.util.IdGenerator;

public class ImportantDatesFactory {

    public static ImportantDates getImportantDates(String startDate, String endDate){
        return new ImportantDates.Builder().importantDatesCode(IdGenerator.generateId())
                .sDate(startDate)
                .eDate(endDate)
                .build();
    }
}
