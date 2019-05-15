package com.dimitri.service.impl;

import com.dimitri.Repository.TimetableRepository;
import com.dimitri.Repository.impl.TimetableRepositoryImpl;
import com.dimitri.domain.Timetable;
import com.dimitri.factory.TimetableFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TimeTableServiceImplTest {
    private TimetableRepository repository;
    private Timetable c1;
    Set<Timetable> timetables = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        this.repository = TimetableRepositoryImpl.getRepository();
        c1 = TimetableFactory.getTimetable("09:00","4");

    }

    @Test
    public void create() {
        Timetable timetable= this.repository.create(this.c1);
        String times2 = "09:00";
        System.out.println("In create, created = " + timetable);
        Assert.assertEquals(times2,timetable.getTime());
        Assert.assertNotNull(timetable);
        Assert.assertSame(timetable, this.c1);
    }

    @Test
    public void update() {
        Timetable timetable= this.repository.create(this.c1);
        String newTtID = "133";
        Timetable newTable = new Timetable.Builder().copy(timetable).ttID(newTtID).build();
        this.repository.create(newTable);
        System.out.println("In update, Will update = " + newTable);
        Timetable updated = this.repository.update(newTable);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newTable.getTtID(), updated.getTtID());
    }

    @Test
    public void delete() {
        Timetable timetable= this.repository.create(this.c1);
        this.repository.delete(timetable.getTtID());
        System.out.println(this.timetables);
    }

    @Test
    public void read() {
        Timetable timetable= this.repository.create(this.c1);
        System.out.println("In read, courseId = "+ timetable.getTtID());
        Timetable read = this.repository.read(timetable.getTtID());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(c1.getTtID(), this.repository.read(c1.getTtID()).getTtID());

    }


    @Test
    public void getAll() {
        Set<Timetable> tableSet = this.repository.getAll();
        System.out.println("In getAll, all = " + tableSet);
        Assert.assertSame(1, tableSet.size());
    }
}