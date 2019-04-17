package com.dimitri.domain;

public class Lecturer {

    private String lecId;
    private String firstName;
    private String surname;
    private String phoneNumber;
    private String email;

    public Lecturer(){}

    public Lecturer(Builder builder){

        this.lecId = builder.lecId;
        this.firstName = builder.firstName;
        this.surname = builder.surname;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
    }


    public String getLecId() {
        return lecId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmai() {
        return email;
    }

    public static class Builder {

        private String lecId;
        private String firstName;
        private String surname;
        private String phoneNumber;
        private String email;

        public Builder lecId(String lecId){
            this.lecId  = lecId;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder surname(String surname){
            this.surname = surname;
            return this;
        }

        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Lecturer build(){
            return new Lecturer(this);
        }
    }
}
