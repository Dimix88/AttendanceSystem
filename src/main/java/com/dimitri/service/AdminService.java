package com.dimitri.service;

import com.dimitri.domain.Admin;

import java.util.Set;

public interface AdminService extends IService<Admin, String> {
    Set<Admin>getAll();
}
