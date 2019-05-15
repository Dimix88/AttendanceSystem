package com.dimitri.Repository;

import com.dimitri.domain.Admin;

import java.util.Set;

public interface AdminRepository extends Repository<Admin, String> {
    Set<Admin>getAll();
}
