package com.dimitri.Repository;

import com.dimitri.domain.Security;

import java.util.Set;

public interface SecurityRepository extends Repository<Security, String> {
    Set<Security>getAll();
}
