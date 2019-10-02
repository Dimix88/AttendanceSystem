package com.dimitri.service;

import com.dimitri.domain.Enroll;

import java.util.List;

public interface EnrollService extends IService<Enroll,String> {
    List<Enroll> getAll();
}
