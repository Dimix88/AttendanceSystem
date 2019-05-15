package com.dimitri.service;

import com.dimitri.domain.Enroll;
import com.dimitri.service.IService;

import java.util.Set;

public interface EnrollService extends IService<Enroll,String> {
    Set<Enroll>getAll();
}
