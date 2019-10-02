package com.dimitri.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class CollegeSubjects implements Comparable<CollegeSubjects>{
   @Id
   @Column(name="college_SubjectCode")
   private String subjectCode;
    @Column(name="college_Subject_Year")
   private String year;
    @Column(name="college_Subject_Name")
   private String subName;

    public CollegeSubjects(){}

    public CollegeSubjects(Builder builder){
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
        public Builder copy(CollegeSubjects collegeSubjects){
            this.subjectCode = collegeSubjects.subjectCode;
            this.year = collegeSubjects.year;
            this.subName = collegeSubjects.subName;

            return this;
        }
        public CollegeSubjects build(){
            return new CollegeSubjects(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollegeSubjects collegeSubjects = (CollegeSubjects) o;
        return Objects.equals(subjectCode, collegeSubjects.subjectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectCode);
    }

    @Override
    public int compareTo(CollegeSubjects o) {
        return this.subjectCode.compareTo(o.subjectCode);
    }

    @Override
    public String toString() {
        return "CollegeSubjects{" +
                "subjectCode='" + subjectCode + '\'' +
                ", year='" + year + '\'' +
                ", subName='" + subName + '\'' +
                '}';
    }
}
