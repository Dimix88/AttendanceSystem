package com.dimitri.Repository.impl;

import com.dimitri.Repository.NoticesRepository;
import com.dimitri.domain.Notices;

import java.util.HashSet;
import java.util.Set;

public class NoticesRepositoryImpl implements NoticesRepository {
    private static NoticesRepositoryImpl repository = null;
    private Set<Notices> notices;

    private NoticesRepositoryImpl(){
        this.notices = new HashSet<>();
    }

    private Notices findNotices(String noticeID){
        for (Notices classes2: this.notices){
            if (classes2.getNoticeID().equals(noticeID))
                return classes2;
        }
        return null;    }
    public static NoticesRepository getRepository(){
        if(repository == null) repository = new NoticesRepositoryImpl();
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
