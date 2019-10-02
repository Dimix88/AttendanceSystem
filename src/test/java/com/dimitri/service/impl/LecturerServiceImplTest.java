package com.dimitri.service.impl;

import com.dimitri.repository.LecturerIRepository;
//import com.dimitri.repository.impl.LecturerIRepositoryImpl;
import com.dimitri.domain.Lecturer;
import com.dimitri.factory.LecturerFactory;
import com.dimitri.service.LecturerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LecturerServiceImplTest {
    private LecturerService lecturerService;
    private LecturerIRepository repository;
    private Lecturer c1;

    @Before
    public void setUp() throws Exception {
        this.lecturerService = LecturerServiceImpl.getLecturerService();
        c1 = LecturerFactory.getLecturer("Ben","Parks","02166666","ben@gmail.com");
        this.lecturerService.create(c1);
    }

    @Test
    public void create() {
        Lecturer lecturer= LecturerFactory.getLecturer("Mike","Parks","02166666","ben@gmail.com");
        this.lecturerService.create(lecturer);
        String name = "Mike";
        Assert.assertEquals(lecturer.getLecId(),lecturerService.read(lecturer.getLecId()).getFirstName());
        Assert.assertNotNull(lecturer);
        Assert.assertEquals(name, lecturerService.read(lecturer.getLecId()).getFirstName());
        Assert.assertSame(lecturer, lecturerService.read(lecturer.getLecId()));
    }

    @Test
    public void update() {
        String newLecturerName = "Ben";
        Lecturer newLecturer = new Lecturer.Builder().copy(c1).lecId(newLecturerName).build();
        this.lecturerService.update(newLecturer);
        Assert.assertEquals(newLecturer,lecturerService.read(c1.getLecId()));
    }

    @Test
    public void delete() {
        Lecturer deleteLecturer= LecturerFactory.getLecturer("James","Homes","02166666","ben@gmail.com");
        lecturerService.create(deleteLecturer);
        lecturerService.delete(deleteLecturer.getLecId());
        Lecturer result = lecturerService.read(deleteLecturer.getLecId());
        Assert.assertFalse(lecturerService.getAll().iterator().next().getFirstName().contains("James"));
        Assert.assertNull(result);
    }

    @Test
    public void read() {
        Lecturer read= this.lecturerService.create(this.c1);
        Assert.assertEquals(read, lecturerService.read(read.getLecId()));
        Assert.assertEquals(read, lecturerService.read(c1.getLecId()));

    }


    @Test
    public void getAll() {
        List<Lecturer> lecturersSet = this.lecturerService.getAll();
        System.out.println("In getAll, all = " + lecturersSet);
        Assert.assertSame(lecturersSet.size(),lecturerService.getAll().size());
    }
}