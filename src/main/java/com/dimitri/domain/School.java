package com.dimitri.domain;

public class School {
    private String schoolCode;
    private String schoolName;
    private String lecId;

    public School(){}

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
        

    }
}
