package com.dimitri.service;

import com.dimitri.domain.School;

import java.util.Set;

public interface SchoolService extends IService<School, String> {
    Set<School>getAll();
}
