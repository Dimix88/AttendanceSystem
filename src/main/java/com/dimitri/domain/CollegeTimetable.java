package com.dimitri.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class CollegeTimetable implements Comparable<CollegeTimetable> {
    @Id
    @Column(name="timetable_ID")
    private String ttID;
    @Column(name="timetable_Time")
    private String time;
    @Column(name="timetable_Day")
    private String  day;

    public CollegeTimetable(){}

    public CollegeTimetable(Builder builder){
        this.ttID = builder.ttID;
        this.time = builder.time;
        this.day = builder.day;
    }

    public String getTime() {
        return time;
    }

    public String getDay() {
        return day;
    }

    public String getTtID() {
        return ttID;
    }
    public static class Builder{
        String ttID;
        String time;
        String  day;

        public Builder ttID(String ttID){
            this.ttID = ttID;
            return this;
        }
        public Builder time(String time){
            this.time = time;
            return this;
        }
        public Builder day(String day){
            this.day = day;
            return this;
        }
        public Builder copy(CollegeTimetable collegeTimetable){
            this.ttID = collegeTimetable.ttID;
            this.time = collegeTimetable.time;
            this.day = collegeTimetable.day;

            return this;
        }
        public CollegeTimetable build(){
            return new CollegeTimetable(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollegeTimetable collegeTimetable = (CollegeTimetable) o;
        return Objects.equals(ttID, collegeTimetable.ttID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ttID);
    }

    @Override
    public int compareTo(CollegeTimetable o) {
        return this.ttID.compareTo(o.ttID);
    }

    @Override
    public String toString() {
        return "CollegeTimetable{" +
                "ttID='" + ttID + '\'' +
                ", time='" + time + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}
