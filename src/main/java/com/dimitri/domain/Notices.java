package com.dimitri.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Notices implements Comparable<Notices> {
    @Id
    private String noticeID;
    private String notice;

    public Notices(){}

    public Notices(Builder builder){
        this.noticeID = builder.noticeID;
        this.notice = builder.notice;
    }

    public String getNoticeID() {
        return noticeID;
    }

    public String getNotice() {
        return notice;
    }

    public static class Builder{
        String noticeID;
        String notice;

        public Builder noticeID(String noticeID){
            this.noticeID = noticeID;
            return this;
        }
        public Builder notice(String notice){
            this.notice = notice;
            return this;
        }
        public Builder copy(Notices notices){
            this.noticeID = notices.noticeID;
            this.notice = notices.notice;

            return this;
        }
        public Notices build(){
            return new Notices(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notices notices = (Notices) o;
        return Objects.equals(noticeID, notices.noticeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noticeID);
    }

    @Override
    public int compareTo(Notices o) {
        return this.noticeID.compareTo(o.noticeID);
    }

    @Override
    public String toString() {
        return "Notices{" +
                "noticeID='" + noticeID + '\'' +
                ", notice='" + notice + '\'' +
                '}';
    }
}
