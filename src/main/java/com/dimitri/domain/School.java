package com.dimitri.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class School implements Comparable<School> {
    @Id
    private String schoolCode;
    private String schoolName;
    private String lecId;

    public School(){}

    public School(Builder builder){
        this.schoolCode = builder.schoolCode;
        this.schoolName = builder.schoolName;
        this.lecId = builder.lecId;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getLecId() {
        return lecId;
    }

    public static class Builder{
        private String schoolCode;
        private String schoolName;
        private String lecId;

        public Builder schoolCode(String schoolCode){
            this.schoolCode = schoolCode;
            return this;
        }
        public Builder schoolName(String schoolName){
            this.schoolName = schoolName;
            return  this;
        }
        public Builder lecId(String lecId){
            this.lecId = lecId;
            return this;
        }public Builder copy(School school){
            this.schoolCode = school.schoolCode;
            this.schoolName = school.schoolName;
            this.lecId = school.lecId;

            return this;
        }
        public School build(){return new School(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return schoolCode.equals(school.schoolCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolCode);
    }

    @Override
    public int compareTo(School o) {
        return this.schoolCode.compareTo(o.schoolCode);
    }
}
