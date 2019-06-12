package com.dimitri.repository.impl;

import com.dimitri.repository.NoticesIRepository;
import com.dimitri.domain.Notices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Repository("NoticeRepository")
public class NoticesIRepositoryImpl implements NoticesIRepository {
    @Autowired
    private static NoticesIRepositoryImpl repository = null;
    private Set<Notices> notices;

    private NoticesIRepositoryImpl(){
        this.notices = new HashSet<>();
    }

    private Notices findNotices(String noticeID){
        for (Notices classes2: this.notices){
            if (classes2.getNoticeID().equals(noticeID))
                return classes2;
        }
        return null;    }
    public static NoticesIRepository getRepository(){
        if(repository == null) repository = new NoticesIRepositoryImpl();
        return repository;
    }
    @Override
    public Notices create(Notices notices) {
        this.notices.add(notices);
        return notices;
    }

    @Override
    public Notices update(Notices notices) {
        Notices toDelete = findNotices(notices.getNoticeID());
        if(toDelete != null) {
            this.notices.remove(toDelete);
            return create(notices);
        }
        return null;
    }

    @Override
    public void delete(String noticeID) {
        Notices class1 = findNotices(noticeID);
        if(class1 != null){
            this.notices.remove(class1);
        }    }

    @Override
    public Notices read(String noticeID) {
        return findNotices(noticeID);
    }
    public Set<Notices> getAll(){
        return this.notices;
    }
}
