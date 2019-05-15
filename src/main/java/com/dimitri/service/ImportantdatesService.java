package com.dimitri.service;

import com.dimitri.Repository.Repository;
import com.dimitri.domain.ImportantDates;

import java.util.Set;

public interface ImportantdatesService extends Repository<ImportantDates, String> {
    Set<ImportantDates>getAll();
}
