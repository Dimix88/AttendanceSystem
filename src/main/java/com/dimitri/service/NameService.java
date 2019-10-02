package com.dimitri.service;

import com.dimitri.domain.Name;

import java.util.List;

public interface NameService extends IService<Name, String> {
    List<Name> getAll();
}
