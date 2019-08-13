package com.dimitri.service.impl;

import com.dimitri.repository.LecturerIRepository;
import com.dimitri.repository.impl.LecturerIRepositoryImpl;
import com.dimitri.domain.Lecturer;
import com.dimitri.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("LecturerServiceImpl")
public class LecturerServiceImpl implements LecturerService {
    @Autowired
    @Qualifier("LecturerRepository")

    private LecturerIRepository repository = null;

    @Override
    public Set<Lecturer> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Lecturer create(Lecturer lecturer) {
        return this.repository.create(lecturer);
    }

    @Override
    public Lecturer update(Lecturer lecturer) {
        return this.repository.update(lecturer);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Lecturer read(String s) {
        return this.repository.read(s);
    }
}
