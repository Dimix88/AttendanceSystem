package com.dimitri.service.impl;

import com.dimitri.repository.SecurityIRepository;
//import com.dimitri.repository.impl.SecurityIRepositoryImpl;
import com.dimitri.domain.Security;
import com.dimitri.factory.SecurityFactory;
import com.dimitri.service.SecurityService;
import com.dimitri.service.SemesterService;
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
public class SecurityServiceImplTest {
    private SecurityService securityService;
    private SecurityIRepository repository;
    private Security c1;

    @Before
    public void setUp() throws Exception {
        this.securityService = SecurityServiceImpl.getSecurityService();
        c1 = SecurityFactory.getSecurity("Dimitri","Ferus","1000000","mm@gmail.com");
        this.securityService.create(c1);
    }

    @Test
    public void create() {
        Security security= SecurityFactory.getSecurity("Mike","Ferus","1000000","mm@gmail.com");
        this.securityService.create(security);
        String name = "Mike";
        Assert.assertEquals(security.getSecurityId(),securityService.read(security.getSecurityId()).getSecurityName());
        Assert.assertNotNull(security);
        Assert.assertEquals(name, securityService.read(security.getSecurityId()).getSecurityName());
        Assert.assertSame(security, securityService.read(security.getSecurityId()));
    }

    @Test
    public void update() {
        String newSecurityName = "Bill";
        Security newSecurity = new Security.Builder().copy(c1).securityName(newSecurityName).build();
        this.securityService.update(newSecurity);
        Assert.assertEquals(newSecurity,securityService.read(c1.getSecurityId()));
    }

    @Test
    public void delete() {
        Security deleteSecurity= SecurityFactory.getSecurity("Ben","Ferus","1000000","mm@gmail.com");
        securityService.create(deleteSecurity);
        securityService.delete(deleteSecurity.getSecurityId());
        Security result = securityService.read(deleteSecurity.getSecurityId());
        Assert.assertFalse(securityService.getAll().iterator().next().getSecurityName().contains("Ben"));
        Assert.assertNull(result);
    }

    @Test
    public void read() {
        Security read = this.securityService.create(this.c1);
        Assert.assertEquals(read, securityService.read(read.getSecurityId()));
        Assert.assertEquals(read, securityService.read(c1.getSecurityId()));

    }


    @Test
    public void getAll() {
        List<Security> securitiesSet = this.securityService.getAll();
        System.out.println("In getAll, all = " + securitiesSet);
        Assert.assertSame(securitiesSet.size(),securityService.getAll().size());
    }
}