package com.dimitri.service.impl;

import com.dimitri.repository.CleanerIRepository;
//import com.dimitri.repository.impl.CleanerIRepositoryImpl;
import com.dimitri.domain.Cleaner;
import com.dimitri.factory.CleanerFactory;
import com.dimitri.service.CleanerService;
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
public class CleanerServiceImplTest {
    private CleanerService cleanerService;
    private CleanerIRepository repository;
    private Cleaner c1;
    Set<Cleaner> cleaners = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        this.cleanerService = CleanerServiceImpl.getCleanerService();
        c1 = CleanerFactory.getCleaner("Dimitri","Ferus","1000000","mm@gmail.com");
        cleanerService.create(c1);
    }

    @Test
    public void create() {
        Cleaner cleaner= CleanerFactory.getCleaner("Mike","Ferus","1000000","mm@gmail.com");
        cleanerService.create(cleaner);
        String name = "Mike";
        Assert.assertEquals(cleaner.getCleanerName(),cleanerService.read(cleaner.getCleanerId()).getCleanerName());
        Assert.assertNotNull(cleaner);
        Assert.assertEquals(name, cleanerService.read(cleaner.getCleanerId()).getCleanerName());
        Assert.assertSame(cleaner, cleanerService.read(cleaner.getCleanerId()));
    }

    @Test
    public void update() {
        String newCleanerName = "John";
        Cleaner newCleaner = new Cleaner.Builder().copy(c1).cleanerName(newCleanerName).build();
        this.cleanerService.update(newCleaner);
        Assert.assertEquals(newCleaner,cleanerService.read(c1.getCleanerId()));
    }

    @Test
    public void delete() {
        Cleaner deleteCleaner= CleanerFactory.getCleaner("Jeff","Probst","","");
        cleanerService.create(deleteCleaner);
        cleanerService.delete(deleteCleaner.getCleanerId());
        Cleaner result = cleanerService.read(deleteCleaner.getCleanerId());
        Assert.assertFalse(cleanerService.getAll().iterator().next().getCleanerName().contains("Jeff"));
        Assert.assertNull(result);
    }

    @Test
    public void read() {
        Cleaner read= this.cleanerService.create(this.c1);
        Assert.assertEquals(read, cleanerService.read(read.getCleanerId()));
        Assert.assertEquals(read, cleanerService.read(c1.getCleanerId()));
    }


    @Test
    public void getAll() {
        List<Cleaner> cleanerSet = this.cleanerService.getAll();
        System.out.println("In getAll, all = " + cleanerSet);
        Assert.assertSame(cleanerSet.size(),cleanerService.getAll().size());
    }
}