package com.dimitri.service;

import com.dimitri.domain.Classes;

import java.util.Set;

public interface ClassesService extends IService<Classes, String> {
    Set<Classes>getAll();
}
