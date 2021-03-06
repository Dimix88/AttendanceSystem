/**package com.dimitri.repository.impl;

import com.dimitri.repository.NoticesIRepository;
import com.dimitri.domain.Notices;
import com.dimitri.factory.NoticesFactory;
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
public class NoticesIRepositoryImplTest {
    @Autowired
    private NoticesIRepository repository;
    private Notices c1;
    Set<Notices> notices = new HashSet<>();

    @Before
    public void setUp() throws Exception {

        c1 = NoticesFactory.getNotices("eat");

    }

    @Test
    public void create() {
        Notices notices= this.repository.create(this.c1);
        String name = "eat";
        System.out.println("In create, created = " + notices);
        Assert.assertEquals(name,notices.getNotice());
        Assert.assertNotNull(notices);
        Assert.assertSame(notices, this.c1);
    }

    @Test
    public void update() {
        Notices notices= this.repository.create(this.c1);
        String newNoticeID = "133";
        Notices newNotice = new Notices.Builder().copy(notices).noticeID(newNoticeID).build();
        this.repository.create(newNotice);
        System.out.println("In update, Will update = " + newNotice);
        Notices updated = this.repository.update(newNotice);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newNotice.getNoticeID(), updated.getNoticeID());
    }

    @Test
    public void delete() {
        Notices notices= this.repository.create(this.c1);
        this.repository.delete(notices.getNoticeID());
        System.out.println(this.notices);
    }

    @Test
    public void read() {
        Notices notices= this.repository.create(this.c1);
        System.out.println("In read, courseId = "+ notices.getNoticeID());
        Notices read = this.repository.read(notices.getNoticeID());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(c1.getNoticeID(), this.repository.read(c1.getNoticeID()).getNoticeID());

    }


    @Test
    public void getAll() {
        Set<Notices> noticeSet = this.repository.getAll();
        System.out.println("In getAll, all = " + noticeSet);
        Assert.assertSame(4, noticeSet.size());
    }
}**/