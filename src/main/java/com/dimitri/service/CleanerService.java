package com.dimitri.service;

import com.dimitri.domain.Cleaner;

import java.util.Set;

public interface CleanerService extends IService<Cleaner,String> {
    Set<Cleaner>getAll();
}
