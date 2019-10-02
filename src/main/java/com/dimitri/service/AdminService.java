package com.dimitri.service;

import com.dimitri.domain.Admin;

import java.util.List;

public interface AdminService extends IService<Admin, String> {
    List<Admin> getAll();
}
