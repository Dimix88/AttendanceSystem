/**package com.dimitri.repository.impl;

import com.dimitri.repository.ImportantdatesIRepository;
import com.dimitri.domain.ImportantDates;
import com.dimitri.factory.ImportantDatesFactory;
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

@SpringBootTest
@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringRunner.class)
public class ImportantDatesIRepositoryImplTest {
    @Autowired
    private ImportantdatesIRepository repository;
    private ImportantDates c1;
    Set<ImportantDates> importantDates = new HashSet<>();

    @Before
    public void setUp() throws Exception {

        c1 = ImportantDatesFactory.getImportantDates("20/11/2019","25/11/2019");

    }

    @Test
    public void create() {
        ImportantDates importantDates= this.repository.create(this.c1);
        String date = "20/11/2019";
        System.out.println("In create, created = " + importantDates);
        Assert.assertEquals(date,importantDates.getsDate());
        Assert.assertNotNull(importantDates);
        Assert.assertSame(importantDates, this.c1);
    }

    @Test
    public void update() {
        ImportantDates importantDates= this.repository.create(this.c1);
        String newSDate = "133";
        ImportantDates newDate = new ImportantDates.Builder().copy(importantDates).sDate(newSDate).build();
        this.repository.create(newDate);
        System.out.println("In update, Will update = " + newDate);
        ImportantDates updated = this.repository.update(newDate);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newDate.getsDate(), updated.getsDate());
    }

    @Test
    public void delete() {
        ImportantDates importantDates= this.repository.create(this.c1);
        this.repository.delete(importantDates.getImportantDatesCode());
        System.out.println(this.importantDates);
    }

    @Test
    public void read() {
        ImportantDates importantDates= this.repository.create(this.c1);
        System.out.println("In read, courseId = "+ importantDates.getsDate());
        ImportantDates read = this.repository.read(importantDates.getsDate());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(c1.getsDate(), this.repository.read(c1.getsDate()).getsDate());

    }


    @Test
    public void getAll() {
        Set<ImportantDates> datesSet = this.repository.getAll();
        System.out.println("In getAll, all = " + datesSet);
        Assert.assertSame(2, datesSet.size());
    }
}**/