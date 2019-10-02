package com.dimitri.service;

import com.dimitri.domain.School;

import java.util.List;

public interface SchoolService extends IService<School, String> {
    List<School> getAll();
}
