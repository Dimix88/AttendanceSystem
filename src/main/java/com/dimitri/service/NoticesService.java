package com.dimitri.service;

import com.dimitri.domain.Notices;

import java.util.List;

public interface NoticesService extends IService<Notices,String> {
    List<Notices> getAll();
}
