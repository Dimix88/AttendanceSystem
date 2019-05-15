package com.dimitri.domain;

import java.util.Objects;

public class Subjects implements Comparable<Subjects>{
   private String subjectCode;
   private String year;
   private String subName;

    public Subjects(){}

    public Subjects(Builder builder){
        this.subjectCode = builder.subjectCode;
        this.year = builder.year;
        this.subName = builder.subName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getYear() {
        return year;
    }

    public String getSubName() {
        return subName;
    }

    public static class Builder{
        String subjectCode;
        String year;
        String subName;

        public Builder subjectCode(String subjectCode){
            this.subjectCode = subjectCode;
            return this;
        }
        public Builder year(String year){
            this.year = year;
            return this;
        }
        public Builder subName(String subName){
            this.subName = subName;
            return this;
        }
        public Builder copy(Subjects subjects){
            this.subjectCode = subjects.subjectCode;
            this.year = subjects.year;
            this.subName = subjects.subName;

            return this;
        }
        public Subjects build(){
            return new Subjects(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subjects subjects = (Subjects) o;
        return Objects.equals(subjectCode, subjects.subjectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectCode);
    }

    @Override
    public int compareTo(Subjects o) {
        return this.subjectCode.compareTo(o.subjectCode);
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "subjectCode='" + subjectCode + '\'' +
                ", year='" + year + '\'' +
                ", subName='" + subName + '\'' +
                '}';
    }
}
