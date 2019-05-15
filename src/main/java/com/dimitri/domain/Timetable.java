package com.dimitri.domain;

import java.util.Objects;

public class Timetable implements Comparable<Timetable> {
    private String ttID;
    private String time;
    private String  day;

    public Timetable(){}

    public Timetable(Builder builder){
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
        public Builder copy(Timetable timetable){
            this.ttID = timetable.ttID;
            this.time = timetable.time;
            this.day = timetable.day;

            return this;
        }
        public Timetable build(){
            return new Timetable(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timetable timetable = (Timetable) o;
        return Objects.equals(ttID, timetable.ttID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ttID);
    }

    @Override
    public int compareTo(Timetable o) {
        return this.ttID.compareTo(o.ttID);
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "ttID='" + ttID + '\'' +
                ", time='" + time + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}
