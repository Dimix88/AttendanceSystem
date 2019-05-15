package com.dimitri.service;

import com.dimitri.domain.Name;

import java.util.Set;

public interface NameService extends IService<Name, String> {
    Set<Name>getAll();
}
