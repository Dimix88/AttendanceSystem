package com.dimitri.repository.impl;

import com.dimitri.repository.CleanerIRepository;
import com.dimitri.domain.Cleaner;
import com.dimitri.factory.CleanerFactory;
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
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class CleanerIRepositoryImplTest {
    @Autowired
    private CleanerIRepository repository;
    private Cleaner c1;
    Set<Cleaner> cleaners = new HashSet<>();

    @Before
    public void setUp() throws Exception {

        c1 = CleanerFactory.getCleaner("Dimitri","Ferus","1000000","mm@gmail.com");

    }

    @Test
    public void create() {
        Cleaner cleaner= this.repository.create(this.c1);
        String name = "Dimitri";
        System.out.println("In create, created = " + cleaner);
        Assert.assertEquals(name,cleaner.getCleanerName());
        Assert.assertNotNull(cleaner);
        Assert.assertSame(cleaner, this.c1);
    }

    @Test
    public void update() {
        Cleaner cleaner= this.repository.create(this.c1);
        String newCleanerId = "133";
        Cleaner newCleaner = new Cleaner.Builder().copy(cleaner).cleanerId(newCleanerId).build();
        this.repository.create(newCleaner);
        System.out.println("In update, Will update = " + newCleanerId);
        Cleaner updated = this.repository.update(newCleaner);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newCleaner.getCleanerId(), updated.getCleanerId());
    }

    @Test
    public void delete() {
        Cleaner cleaner= this.repository.create(this.c1);
        this.repository.delete(cleaner.getCleanerId());
        System.out.println(this.cleaners);
    }

    @Test
    public void read() {
        Cleaner cleaner= this.repository.create(this.c1);
        System.out.println("In read, courseId = "+ cleaner.getCleanerId());
        Cleaner read = this.repository.read(cleaner.getCleanerId());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(c1.getCleanerId(), this.repository.read(c1.getCleanerId()).getCleanerId());

    }


    @Test
    public void getAll() {
        Set<Cleaner> cleanerSet = this.repository.getAll();
        System.out.println("In getAll, all = " + cleanerSet);
        Assert.assertSame(4, cleanerSet.size());
    }
}