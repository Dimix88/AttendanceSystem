package com.dimitri.service.impl;

import com.dimitri.repository.NoticesIRepository;
//import com.dimitri.repository.impl.NoticesIRepositoryImpl;
import com.dimitri.domain.Notices;
import com.dimitri.factory.NoticesFactory;
import com.dimitri.service.NoticesService;
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
public class NoticesServiceImplTest {
    private NoticesService noticesService;
    private NoticesIRepository repository;
    private Notices c1;

    @Before
    public void setUp() throws Exception {
        this.noticesService = NoticesServiceImpl.getNoticesService();
        c1 = NoticesFactory.getNotices("eat");
        noticesService.create(c1);
    }

    @Test
    public void create() {
        Notices notices= NoticesFactory.getNotices("sleep");
        String name = "sleep";
        Assert.assertEquals(notices.getNotice(),noticesService.read(notices.getNoticeID()).getNotice());
        Assert.assertNotNull(notices);
        Assert.assertEquals(name, noticesService.read(notices.getNoticeID()).getNotice());
        Assert.assertSame(notices, noticesService.read(notices.getNoticeID()));
    }

    @Test
    public void update() {
        String newNoticeNote = "133";
        Notices newNotice = new Notices.Builder().copy(c1).notice(newNoticeNote).build();
        this.noticesService.update(newNotice);
        Assert.assertEquals(newNotice,noticesService.read(c1.getNoticeID()));
    }

    @Test
    public void delete() {
        Notices deleteNotices= NoticesFactory.getNotices("walk");
        noticesService.create(deleteNotices);
        noticesService.delete(deleteNotices.getNoticeID());
        Notices result = noticesService.read(deleteNotices.getNoticeID());
        Assert.assertFalse(noticesService.getAll().iterator().next().getNotice().contains("walk"));
        Assert.assertNull(result);
    }

    @Test
    public void read() {
        Notices read= this.noticesService.create(this.c1);
        Assert.assertEquals(read, noticesService.read(read.getNoticeID()));
        Assert.assertEquals(read, noticesService.read(c1.getNoticeID()));

    }


    @Test
    public void getAll() {
        List<Notices> noticeSet = this.noticesService.getAll();
        System.out.println("In getAll, all = " + noticeSet);
        Assert.assertSame(noticeSet.size(),noticesService.getAll().size());
    }
}