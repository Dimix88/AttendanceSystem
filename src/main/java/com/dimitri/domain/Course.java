package com.dimitri.domain;

public class Course {

 private String courseId;
 private String courseName;

 public Course(){}

 public Course(Builder builder){

     this.courseId = builder.courseId;
     this.courseName = builder.courseName;
 }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public static class Builder{

        private String courseId;
        private String courseName;

        public Builder courseId(String courseId){
            this.courseId = courseId;
            return this;
        }

        public Builder courseName(String courseName){
            this.courseName = courseName;
            return this;
        }

        public Course build(){
            return new Course(this);
        }

    }
}