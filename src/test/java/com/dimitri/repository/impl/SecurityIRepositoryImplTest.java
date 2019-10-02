/***package com.dimitri.repository.impl;

import com.dimitri.repository.SecurityIRepository;
import com.dimitri.domain.Security;
import com.dimitri.factory.SecurityFactory;
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
public class SecurityIRepositoryImplTest {
    @Autowired
    private SecurityIRepository repository;
    private Security c1;
    Set<Security> securities = new HashSet<>();

    @Before
    public void setUp() throws Exception {

        c1 = SecurityFactory.getSecurity("Dimitri","Ferus","1000000","mm@gmail.com");

    }

    @Test
    public void create() {
        Security security= this.repository.create(this.c1);
        String name = "Dimitri";
        System.out.println("In create, created = " + security);
        Assert.assertEquals(name,security.getSecurityName());
        Assert.assertNotNull(security);
        Assert.assertSame(security, this.c1);
    }

    @Test
    public void update() {
        Security security= this.repository.create(this.c1);
        String newSecurityId = "133";
        Security newSecurity = new Security.Builder().copy(security).securityId(newSecurityId).build();
        this.repository.create(newSecurity);
        System.out.println("In update, Will update = " + newSecurity);
        Security updated = this.repository.update(newSecurity);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newSecurity.getSecurityId(), updated.getSecurityId());
    }

    @Test
    public void delete() {
        Security security= this.repository.create(this.c1);
        this.repository.delete(security.getSecurityId());
        System.out.println(this.securities);
    }

    @Test
    public void read() {
        Security security= this.repository.create(this.c1);
        System.out.println("In read, courseId = "+ security.getSecurityId());
        Security read = this.repository.read(security.getSecurityId());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(c1.getSecurityId(), this.repository.read(c1.getSecurityId()).getSecurityId());

    }


    @Test
    public void getAll() {
        Set<Security> securitiesSet = this.repository.getAll();
        System.out.println("In getAll, all = " + securitiesSet);
        Assert.assertSame(4, securitiesSet.size());
    }
}**/