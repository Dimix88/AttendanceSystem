package com.dimitri.service;

import com.dimitri.domain.Notices;

import java.util.Set;

public interface NoticesService extends IService<Notices,String> {
    Set<Notices>getAll();
}
