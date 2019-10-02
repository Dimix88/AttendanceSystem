package com.dimitri.service;

import com.dimitri.domain.Classes;

import java.util.List;

public interface ClassesService extends IService<Classes, String> {
    List<Classes> getAll();
}
