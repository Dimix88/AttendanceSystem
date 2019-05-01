package com.dimitri.domain;

import java.util.Objects;
import java.util.Set;

public class Student implements Comparable<Student> {
    private String studentId;
    private String studentName;
    private String studentSurname;
    private String studentPhoneNr;
    private String studentEmail;


    private Student(){}

    private Student(Builder builder) {
        this.studentId = builder.studentId;
        this.studentName = builder.studentName;
        this.studentSurname = builder.studentSurname;
        this.studentPhoneNr = builder.studentPhoneNr;
        this.studentEmail = builder.studentEmail;
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

    @Override
    public int compareTo(Student o) {
        return this.studentId.compareTo(o.studentId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    public static class Builder{

        private String studentId;
        private String studentName;
        private String studentSurname;
        private String studentPhoneNr;
        private String studentEmail;

        public Builder studentId(String studentId){
            this.studentId = studentId;
            return this;
        }

        public Builder studentName(String studentName){
            this.studentName = studentName;
            return this;

        }

        public Builder studentSurname(String studentSurname){
            this.studentSurname = studentSurname;
            return this;
        }
        public Builder studentPhoneNr(String studentPhoneNr){
            this.studentPhoneNr = studentPhoneNr;
            return this;
        }
        public Builder studentEmail(String studentEmail){
            this.studentEmail = studentEmail;
            return this;
        }
        public Builder copy(Student student){
            this.studentId = student.studentId;
            this.studentName = student.studentName;
            this.studentSurname = student.studentSurname;
            this.studentPhoneNr = student.studentPhoneNr;
            this.studentEmail = student.studentEmail;
            return this;
        }

        public Student build() {
            return new Student(this);
        }

    }


}
