package com.dimitri.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Classes implements Comparable<Classes> {
    @Id
    private String classCode;
    private String courseCode;
    private String lecturerId;
    private String classTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classes classes = (Classes) o;
        return classCode.equals(classes.classCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classCode);
    }

    public Classes(){}

    public Classes(Builder builder){
        this.classCode = builder.classCode;
        this.courseCode = builder.courseCode;
        this.lecturerId = builder.lecturerId;
        this.classTime = builder.classTime;
    }



    public String getClassCode() {
        return classCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public String getClassTime() {
        return classTime;
    }

    @Override
    public int compareTo(Classes o) {
        return this.classCode.compareTo(o.classCode);
    }

    public static class Builder{
        String classCode;
        String courseCode;
        String lecturerId;
        String classTime;

        public Builder classCode(String classCode){
            this.classCode = classCode;
            return this;
        }
        public Builder courseCode(String courseCode){
            this.courseCode = courseCode;
            return this;
        }
        public Builder lecturerId(String lecturerId){
            this.lecturerId = lecturerId;
            return this;
        }
        public Builder classTime(String classTime){
            this.classTime = classTime;
            return this;
        }
        public Builder copy(Classes classes){
            this.classCode = classes.classCode;
            this.courseCode = classes.courseCode;
            this.lecturerId = classes.lecturerId;
            this.classTime = classes.classTime;

            return this;
        }
        public Classes build(){
            return new Classes(this);
        }

    }

    @Override
    public String toString() {
        return "Classes{" +
                "classCode='" + classCode + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", lecturerId='" + lecturerId + '\'' +
                ", classTime='" + classTime + '\'' +
                '}';
    }
}
