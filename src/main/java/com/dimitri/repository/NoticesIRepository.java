package com.dimitri.repository;

import com.dimitri.domain.Notices;
import com.dimitri.repository.IRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

public interface NoticesIRepository extends IRepository<Notices,String> {
    Set<Notices>getAll();
}
