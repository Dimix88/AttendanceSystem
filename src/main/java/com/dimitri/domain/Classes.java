package com.dimitri.domain;

public class Classes {

    private String classCode;
    private String courseCode;
    private String lecturerId;
    private String classTime;

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
        public Classes build(){
            return new Classes(this);
        }

    }
}
