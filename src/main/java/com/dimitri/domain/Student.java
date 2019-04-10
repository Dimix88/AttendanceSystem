package com.dimitri.domain;

public class Student {
    private String studentId;
    private String studentName;
    private String studentSurname;

    private Student(){}

    private Student(Builder builder) {
        this.studentId = builder.studentId;
        this.studentName = builder.studentName;
        this.studentSurname = builder.studentSurname;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentSurname='" + studentSurname + '\'' +
                '}';
    }

    public static class Builder{

        private String studentId;
        private String studentName;
        private String studentSurname;

        public Builder studentId(String studentId){
            this.studentId = studentId;
            return this;
        }

        public Builder studentName(String studentName){
            this.studentName = studentName;
            return this;

        }

        public Builder StudentSurname(String studentSurname){
            this.studentSurname = studentSurname;
            return this;
        }

        public Student build() {
            return new Student(this);
        }

    }

}
