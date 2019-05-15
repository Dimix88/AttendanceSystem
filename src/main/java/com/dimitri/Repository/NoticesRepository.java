package com.dimitri.Repository;

import com.dimitri.domain.Notices;

import java.util.Set;

public interface NoticesRepository extends Repository<Notices,String> {
    Set<Notices>getAll();
}
