package com.dimitri.service;

import com.dimitri.domain.Cleaner;

import java.util.List;

public interface CleanerService extends IService<Cleaner,String> {
    List<Cleaner> getAll();
}
