package com.dimitri.service.impl;

import com.dimitri.repository.ImportantdatesIRepository;
//import com.dimitri.repository.impl.ImportantDatesIRepositoryImpl;
import com.dimitri.domain.ImportantDates;
import com.dimitri.factory.ImportantDatesFactory;
import com.dimitri.service.ImportantdatesService;
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
public class ImportantDatesServiceImplTest {
    private ImportantdatesService importantdatesService;
    private ImportantdatesIRepository repository;
    private ImportantDates c1;

    @Before
    public void setUp() throws Exception {
        this.importantdatesService = ImportantDatesServiceImpl.getImportantdatesService();
        c1 = ImportantDatesFactory.getImportantDates("20/11/2019","25/11/2019");
        this.importantdatesService.create(c1);
    }

    @Test
    public void create() {
        ImportantDates importantDates= ImportantDatesFactory.getImportantDates("20/11/2013","25/11/2019");
        this.importantdatesService.create(importantDates);
        String date = "20/11/2013";
        Assert.assertEquals(importantDates.getImportantDatesCode(),importantdatesService.read(importantDates.getImportantDatesCode()).getsDate());
        Assert.assertNotNull(importantDates);
        Assert.assertEquals(date, importantdatesService.read(importantDates.getImportantDatesCode()).getsDate());
        Assert.assertSame(importantDates, importantdatesService.read(importantDates.getImportantDatesCode()));
    }

    @Test
    public void update() {
        String newSDate = "133";
        ImportantDates newDate = new ImportantDates.Builder().copy(c1).sDate(newSDate).build();
        this.importantdatesService.update(newDate);
        Assert.assertEquals(newSDate,importantdatesService.read(c1.getsDate()));
    }

    @Test
    public void delete() {
        ImportantDates deleteImportantDates= ImportantDatesFactory.getImportantDates("20/11/2016","25/11/2018");
        importantdatesService.create(deleteImportantDates);
        importantdatesService.delete(deleteImportantDates.getImportantDatesCode());
        ImportantDates result = importantdatesService.read(deleteImportantDates.getImportantDatesCode());
        Assert.assertFalse(importantdatesService.getAll().iterator().next().getsDate().contains("20/11/2016"));
        Assert.assertNull(result);
    }

    @Test
    public void read() {
        ImportantDates read = this.importantdatesService.create(this.c1);
        Assert.assertEquals(read, importantdatesService.read(read.getImportantDatesCode()));
        Assert.assertEquals(read, importantdatesService.read(c1.getImportantDatesCode()));

    }


    @Test
    public void getAll() {
        List<ImportantDates> datesSet = this.importantdatesService.getAll();
        System.out.println("In getAll, all = " + datesSet);
        Assert.assertSame(datesSet.size(),importantdatesService.getAll().size());
    }
}