package com.dimitri.service.impl;

import com.dimitri.Repository.LecturerRepository;
import com.dimitri.Repository.impl.LecturerRepositoryImpl;
import com.dimitri.domain.Lecturer;
import com.dimitri.factory.LecturerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class LecturerServiceImplTest {

    private LecturerRepository repository;
    private Lecturer c1;
    Set<Lecturer> lecturers = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        this.repository = LecturerRepositoryImpl.getRepository();
        c1 = LecturerFactory.getLecturer("Ben","Parks","02166666","ben@gmail.com");

    }

    @Test
    public void create() {
        Lecturer lecturer= this.repository.create(this.c1);
        String name = "Ben";
        System.out.println("In create, created = " + lecturer);
        Assert.assertEquals(name,lecturer.getFirstName());
        Assert.assertNotNull(lecturer);
        Assert.assertSame(lecturer, this.c1);
    }

    @Test
    public void update() {
        Lecturer lecturer= this.repository.create(this.c1);
        String newLecturerId = "133";
        Lecturer newLecturer = new Lecturer.Builder().copy(lecturer).lecId(newLecturerId).build();
        this.repository.create(newLecturer);
        System.out.println("In update, Will update = " + newLecturer);
        Lecturer updated = this.repository.update(newLecturer);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newLecturer.getLecId(), updated.getLecId());
    }

    @Test
    public void delete() {
        Lecturer lecturer= this.repository.create(this.c1);
        this.repository.delete(lecturer.getLecId());
        System.out.println(this.lecturers);
    }

    @Test
    public void read() {
        Lecturer lecturer= this.repository.create(this.c1);
        System.out.println("In read, courseId = "+ lecturer.getLecId());
        Lecturer read = this.repository.read(lecturer.getLecId());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(c1.getLecId(), this.repository.read(c1.getLecId()).getLecId());

    }


    @Test
    public void getAll() {
        Set<Lecturer> lecturersSet = this.repository.getAll();
        System.out.println("In getAll, all = " + lecturersSet);
        Assert.assertSame(1, lecturersSet.size());
    }
}