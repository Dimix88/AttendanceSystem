package com.dimitri.domain;

import java.util.Objects;

public class Enroll implements Comparable<Enroll> {
    private String courseCode;
    private String studentId;
    private String enrollDate;
    private String enrollGrade;

    public Enroll(){}

    public Enroll(Builder builder){
        this.courseCode = builder.courseCode;
        this.studentId = builder.studentId;
        this.enrollDate = builder.enrollDate;
        this.enrollGrade = builder.enrollGrade;
    }


    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getEnrollDate() {
        return enrollDate;
    }

    public String getEnrollGrade() {
        return enrollGrade;
    }

    public static class Builder{
        private String courseCode;
        private String studentId;
        private String enrollDate;
        private String enrollGrade;

        public Builder courseCode(String courseCode){
            this.courseCode = courseCode;
            return this;
        }
        public Builder studentId(String studenId){
            this.studentId = studenId;
            return this;
        }
        public Builder enrollDate(String enrollDate){
            this.enrollDate = enrollDate;
            return this;
        }
        public Builder enrollGrade(String enrollGrade){
            this.enrollGrade = enrollGrade;
            return this;
        }
        public Builder copy(Enroll enroll){
            this.courseCode = enroll.courseCode;
            this.studentId = enroll.studentId;
            this.enrollDate = enroll.enrollDate;
            this.enrollGrade = enroll.enrollGrade;

            return this;
        }
        public Enroll build(){
            return new Enroll(this);
        }

    }

    @Override
    public int compareTo(Enroll o) {
        return this.studentId.compareTo(o.studentId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enroll enroll = (Enroll) o;
        return studentId.equals(enroll.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
}
