package com.dimitri.service;

import com.dimitri.domain.Lecturer;

import java.util.Set;

public interface LecturerService extends IService<Lecturer, String> {
    Set<Lecturer>getAll();
}
