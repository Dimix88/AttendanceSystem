package com.dimitri.domain;

import java.util.Objects;

public class Course implements Comparable<Course> {

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
        public Builder copy(Course course){
            this.courseId = course.courseId;
            this.courseName = course.courseName;


            return this;
        }

        public Course build(){
            return new Course(this);
        }

    }

    @Override
    public int compareTo(Course o) {
        return this.courseId.compareTo(o.courseId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseId.equals(course.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId);
    }
}