package com.dimitri.service.impl;

import com.dimitri.repository.NameIRepository;
//import com.dimitri.repository.impl.NameIRepositoryImpl;
import com.dimitri.domain.Name;
import com.dimitri.factory.NameFactory;
import com.dimitri.service.NameService;
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
public class NameServiceImplTest {
    private NameService nameService;
    private NameIRepository repository;
    private Name c1;

    @Before
    public void setUp() throws Exception {
        this.nameService = NameServiceImpl.getNameService();
        c1 = NameFactory.getName("Dimitri","John","Bells");
        this.nameService.create(c1);
    }

    @Test
    public void create() {
        Name name = NameFactory.getName("John","Mark","Bells");
        this.nameService.create(name);
        String fName = "John";
        Assert.assertEquals(name.getFirstname(),nameService.read(name.getNameCode()).getFirstname());
        Assert.assertNotNull(name);
        Assert.assertEquals(fName, nameService.read(name.getNameCode()).getFirstname());
        Assert.assertSame(name, nameService.read(name.getNameCode()));
    }

    @Test
    public void update() {
        String changeName = "Jack";
        Name newName = new Name.Builder().copy(c1).firstName(changeName).build();
        this.nameService.update(newName);
        Assert.assertEquals(newName,nameService.read(c1.getNameCode()));
    }

    @Test
    public void delete() {
        Name deleteName= NameFactory.getName("Shane","","Hart");
        nameService.create(deleteName);
        nameService.delete(deleteName.getNameCode());
        Name result = nameService.read(deleteName.getNameCode());
        Assert.assertFalse(nameService.getAll().iterator().next().getFirstname().contains("Shane"));
        Assert.assertNull(result);
    }

    @Test
    public void read() {
        Name read= this.nameService.create(this.c1);;
        Assert.assertEquals(read, nameService.read(read.getNameCode()));
        Assert.assertEquals(read, nameService.read(c1.getNameCode()));

    }


    @Test
    public void getAll() {
        List<Name> nameSet = this.nameService.getAll();
        System.out.println("In getAll, all = " + nameSet);
        Assert.assertSame(nameSet.size(),nameService.getAll().size());
    }
}