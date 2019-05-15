package com.dimitri.Repository.impl;

import com.dimitri.Repository.NameRepository;
import com.dimitri.domain.Name;
import com.dimitri.factory.NameFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class NameRepositoryImplTest {

    private NameRepository repository;
    private Name c1;
    Set<Name> names = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        this.repository = NameRepositoryImpl.getRepository();
        c1 = NameFactory.getName("Dimitri","John","Bells");

    }

    @Test
    public void create() {
        Name name= this.repository.create(this.c1);
        String fName = "Dimitri";
        System.out.println("In create, created = " + name);
        Assert.assertEquals(fName,name.getFirstname());
        Assert.assertNotNull(name);
        Assert.assertSame(name, this.c1);
    }

    @Test
    public void update() {
        Name name= this.repository.create(this.c1);
        String changeName = "Jack";
        Name newName = new Name.Builder().copy(name).firstName(changeName).build();
        this.repository.create(newName);
        System.out.println("In update, Will update = " + newName);
        Name updated = this.repository.update(newName);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName.getFirstname(), updated.getFirstname());
    }

    @Test
    public void delete() {
        Name name= this.repository.create(this.c1);
        this.repository.delete(name.getFirstname());
        System.out.println(this.names);
    }

    @Test
    public void read() {
        Name name= this.repository.create(this.c1);;
        System.out.println("In read, courseId = "+ name.getFirstname());
        Name read = this.repository.read(name.getFirstname());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(c1.getFirstname(), this.repository.read(c1.getFirstname()).getFirstname());

    }


    @Test
    public void getAll() {
        Set<Name> nameSet = this.repository.getAll();
        System.out.println("In getAll, all = " + nameSet);
        Assert.assertSame(1, nameSet.size());
    }
}