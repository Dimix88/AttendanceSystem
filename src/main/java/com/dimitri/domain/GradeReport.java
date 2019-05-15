package com.dimitri.domain;

import java.util.Objects;

public class GradeReport implements Comparable<GradeReport> {
    private String studentID;
    private String gradeLetter;
    private String numericGrade;

    public GradeReport(){}
    public GradeReport(Builder builder){
        this.studentID = builder.studentID;
        this.gradeLetter = builder.gradeLetter;
        this.numericGrade = builder.numericGrade;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getGradeLetter() {
        return gradeLetter;
    }

    public String getNumericGrade() {
        return numericGrade;
    }
    public static class Builder{
        String studentID;
        String gradeLetter;
        String numericGrade;

        public Builder studentID(String studentID){
            this.studentID = studentID;
            return this;
        }
        public Builder gradeLetter(String gradeLetter){
            this.gradeLetter = gradeLetter;
            return this;
        }
        public Builder numericGrade(String numericGrade){
            this.numericGrade = numericGrade;
            return this;
        }
        public Builder copy(GradeReport gradeReport){
            this.studentID = gradeReport.studentID;
            this.gradeLetter = gradeReport.gradeLetter;
            this.numericGrade = gradeReport.numericGrade;
            return  this;
        }
        public GradeReport build(){
            return new GradeReport(this);
        }
    }

    @Override
    public String toString() {
        return "GradeReport{" +
                "studentID='" + studentID + '\'' +
                ", gradeLetter='" + gradeLetter + '\'' +
                ", numericGrade=" + numericGrade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradeReport that = (GradeReport) o;
        return Objects.equals(studentID, that.studentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID);
    }

    @Override
    public int compareTo(GradeReport o) {
        return this.studentID.compareTo(o.studentID);
    }
}
