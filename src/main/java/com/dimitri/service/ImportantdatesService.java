package com.dimitri.service;

import com.dimitri.repository.IRepository;
import com.dimitri.domain.ImportantDates;

import java.util.List;

public interface ImportantdatesService extends IRepository<ImportantDates, String> {
    List<ImportantDates> getAll();
}
