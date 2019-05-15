package com.dimitri.factory;

import com.dimitri.domain.ImportantDates;

public class ImportantDatesFactory {

    public static ImportantDates getImportantDates(String startDate, String endDate){
        return new ImportantDates.Builder().sDate(startDate)
                .eDate(endDate)
                .build();
    }
}
