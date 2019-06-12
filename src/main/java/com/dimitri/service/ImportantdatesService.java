package com.dimitri.service;

import com.dimitri.repository.IRepository;
import com.dimitri.domain.ImportantDates;

import java.util.Set;

public interface ImportantdatesService extends IRepository<ImportantDates, String> {
    Set<ImportantDates>getAll();
}
