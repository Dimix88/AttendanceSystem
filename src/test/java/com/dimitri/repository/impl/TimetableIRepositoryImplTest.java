/**package com.dimitri.repository.impl;

import com.dimitri.repository.TimetableIRepository;
import com.dimitri.domain.CollegeTimetable;
import com.dimitri.factory.TimetableFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.JVM)
public class TimetableIRepositoryImplTest {
    @Autowired
    private TimetableIRepository repository;
    private CollegeTimetable c1;
    Set<CollegeTimetable> timetables = new HashSet<>();

    @Before
    public void setUp() throws Exception {

        c1 = TimetableFactory.getTimetable("09:00","4");

    }

    @Test
    public void create() {
        CollegeTimetable timetable= this.repository.create(this.c1);
        String times2 = "09:00";
        System.out.println("In create, created = " + timetable);
        Assert.assertEquals(times2,timetable.getTime());
        Assert.assertNotNull(timetable);
        Assert.assertSame(timetable, this.c1);
    }

    @Test
    public void update() {
        CollegeTimetable timetable= this.repository.create(this.c1);
        String newTtID = "133";
        CollegeTimetable newTable = new CollegeTimetable.Builder().copy(timetable).ttID(newTtID).build();
        this.repository.create(newTable);
        System.out.println("In update, Will update = " + newTable);
        CollegeTimetable updated = this.repository.update(newTable);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newTable.getTtID(), updated.getTtID());
    }

    @Test
    public void delete() {
        CollegeTimetable timetable= this.repository.create(this.c1);
        this.repository.delete(timetable.getTtID());
        System.out.println(this.timetables);
    }

    @Test
    public void read() {
        CollegeTimetable timetable= this.repository.create(this.c1);
        System.out.println("In read, courseId = "+ timetable.getTtID());
        CollegeTimetable read = this.repository.read(timetable.getTtID());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(c1.getTtID(), this.repository.read(c1.getTtID()).getTtID());

    }


    @Test
    public void getAll() {
        Set<CollegeTimetable> tableSet = this.repository.getAll();
        System.out.println("In getAll, all = " + tableSet);
        Assert.assertSame(4, tableSet.size());
    }
}**/