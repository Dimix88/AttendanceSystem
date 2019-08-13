package com.dimitri.service.impl;

import com.dimitri.repository.EnrollIRepository;
import com.dimitri.repository.impl.EnrollIRepositoryImpl;
import com.dimitri.domain.Enroll;
import com.dimitri.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("EnrollServiceImpl")
public class EnrollServiceImpl implements EnrollService {
    @Autowired
    @Qualifier("EnrollRepository")
    private EnrollIRepository repository = null;

    @Override
    public Set<Enroll> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Enroll create(Enroll enroll) {
        return this.repository.create(enroll);
    }

    @Override
    public Enroll update(Enroll enroll) {
        return this.repository.update(enroll);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Enroll read(String s) {
        return this.repository.read(s);
    }
}
