package com.dimitri.service;

import com.dimitri.domain.Lecturer;

import java.util.List;

public interface LecturerService extends IService<Lecturer, String> {
    List<Lecturer> getAll();
}
