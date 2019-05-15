package com.dimitri.service;

import com.dimitri.domain.Subjects;

import java.util.Set;

public interface SubjectsService extends IService<Subjects, String> {
    Set<Subjects>getAll();
}
