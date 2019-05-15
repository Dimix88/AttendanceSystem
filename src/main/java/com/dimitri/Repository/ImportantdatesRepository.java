package com.dimitri.Repository;

import com.dimitri.domain.ImportantDates;

import java.util.Set;

public interface ImportantdatesRepository extends Repository<ImportantDates, String> {
    Set<ImportantDates>getAll();
}
