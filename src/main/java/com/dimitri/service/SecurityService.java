package com.dimitri.service;

import com.dimitri.domain.Security;

import java.util.Set;

public interface SecurityService extends IService<Security,String> {
    Set<Security>getAll();
}
