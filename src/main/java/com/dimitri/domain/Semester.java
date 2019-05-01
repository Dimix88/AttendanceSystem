package com.dimitri.domain;

import java.util.Objects;

public class Semester implements Comparable<Semester> {
    String semesterCode;
    String semesterYear;
    String semesterTerm;
    String semesterStartDate;
    String semesterEndDate;

    public Semester(){}

    public Semester(Builder builder){
        this.semesterCode = builder.semesterCode;
        this.semesterYear = builder.semesterYear;
        this.semesterTerm = builder.semesterTerm;
        this.semesterStartDate = builder.semesterStartDate;
        this.semesterEndDate = builder.semesterEndDate;
    }

    public String getSemesterCode() {
        return semesterCode;
    }

    public String getSemesterYear() {
        return semesterYear;
    }

    public String getSemesterTerm() {
        return semesterTerm;
    }

    public String getSemesterStartDate() {
        return semesterStartDate;
    }

    public String getSemesterEndDate() {
        return semesterEndDate;
    }
    public static class Builder{
        String semesterCode;
        String semesterYear;
        String semesterTerm;
        String semesterStartDate;
        String semesterEndDate;

        public Builder semesterCode(String semesterCode){
            this.semesterCode = semesterCode;
            return this;
        }
        public Builder semesterYear(String semesterYear){
            this.semesterYear = semesterYear;
            return this;
        }
        public Builder semesterTerm(String semesterTerm){
            this.semesterTerm = semesterTerm;
            return this;
        }
        public Builder semesterStartDate(String semesterStartDate){
            this.semesterStartDate = semesterStartDate;
            return this;
        }
        public Builder semesterEndDate(String semesterEndDate){
            this.semesterEndDate = semesterEndDate;
            return this;
        }
        public Builder copy(Semester semester){
            this.semesterCode = semester.semesterCode;
            this.semesterYear = semester.semesterYear;
            this.semesterTerm = semester.semesterTerm;
            this.semesterStartDate = semester.semesterStartDate;
            this.semesterEndDate = semester.semesterEndDate;
            return this;
        }
        public Semester build(){return new Semester(this);}
    }

    @Override
    public int compareTo(Semester o) {
        return this.semesterCode.compareTo(o.semesterCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Semester semester = (Semester) o;
        return semesterCode.equals(semester.semesterCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(semesterCode);
    }
}
