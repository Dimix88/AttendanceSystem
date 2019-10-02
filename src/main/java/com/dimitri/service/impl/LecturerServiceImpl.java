package com.dimitri.service.impl;

import com.dimitri.repository.LecturerIRepository;
//import com.dimitri.repository.impl.LecturerIRepositoryImpl;
import com.dimitri.domain.Lecturer;
import com.dimitri.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("LecturerServiceImpl")
public class LecturerServiceImpl implements LecturerService {
    public static LecturerService lecturerService = null;

    @Autowired
    private LecturerIRepository repository;

    private LecturerServiceImpl(){}

    public static LecturerService getLecturerService(){
        if (lecturerService==null)lecturerService = new LecturerServiceImpl();
        return lecturerService;
    }
    @Override
    public List<Lecturer> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Lecturer create(Lecturer lecturer) {
        return this.repository.save(lecturer);
    }

    @Override
    public Lecturer update(Lecturer lecturer) {
        return this.repository.save(lecturer);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Lecturer read(String s) {
        Optional<Lecturer>optionalLecturer=this.repository.findById(s);
        return optionalLecturer.orElse(null);
    }
}
