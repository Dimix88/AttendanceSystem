package com.dimitri.service;

import com.dimitri.domain.Security;

import java.util.List;

public interface SecurityService extends IService<Security,String> {
    List<Security> getAll();
}
