package com.dimitri.service.impl;

import com.dimitri.domain.CollegeTimetable;
import com.dimitri.repository.TimetableIRepository;
//import com.dimitri.repository.impl.TimetableIRepositoryImpl;
import com.dimitri.factory.TimetableFactory;
import com.dimitri.service.TimetableService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TimeTableServiceImplTest {
    private TimetableService timetableService;
    private TimetableIRepository repository;
    private CollegeTimetable c1;

    @Before
    public void setUp() throws Exception {
        this.timetableService = TimeTableServiceImpl.getTimetableService();
        c1 = TimetableFactory.getTimetable("09:00","4");
        this.timetableService.create(c1);
    }

    @Test
    public void create() {
        CollegeTimetable collegeTimetable = TimetableFactory.getTimetable("10:00","4");
        String times2 = "10:00";
        Assert.assertEquals(collegeTimetable.getTime(),timetableService.read(collegeTimetable.getTtID()).getTime());
        Assert.assertNotNull(collegeTimetable);
        Assert.assertEquals(times2, timetableService.read(collegeTimetable.getTtID()).getTime());
        Assert.assertSame(collegeTimetable, timetableService.read(collegeTimetable.getTtID()));
    }

    @Test
    public void update() {
        String newDay = "6";
        CollegeTimetable newTable = new CollegeTimetable.Builder().copy(c1).ttID(newDay).build();
        this.timetableService.update(newTable);
        Assert.assertEquals(newTable,timetableService.read(c1.getTtID()));
    }

    @Test
    public void delete() {
        CollegeTimetable deleteCollegeTimetable = TimetableFactory.getTimetable("09:00","7");
        timetableService.create(deleteCollegeTimetable);
        timetableService.delete(deleteCollegeTimetable.getTtID());
        CollegeTimetable result = timetableService.read(deleteCollegeTimetable.getTtID());
        Assert.assertFalse(timetableService.getAll().iterator().next().getDay().contains("7"));
        Assert.assertNull(result);
    }

    @Test
    public void read() {
        CollegeTimetable read= this.timetableService.create(this.c1);
        Assert.assertEquals(read, timetableService.read(read.getTtID()));
        Assert.assertEquals(read, timetableService.read(c1.getTtID()));

    }


    @Test
    public void getAll() {
        List<CollegeTimetable> tableSet = this.timetableService.getAll();
        System.out.println("In getAll, all = " + tableSet);
        Assert.assertSame(tableSet.size(),timetableService.getAll().size());
    }
}