package com.dimitri.domain;

public class Name {
    String firstName;
    String middleName;
    String lastName;

    public Name(){}

    public Name(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;

    }

    public String getFirstname() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class Builder{
        String firstName;
        String middleName;
        String lastName;

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public Builder middleName(String middleName){
            this.middleName = middleName;
            return this;
        }
        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public Name build(){
            return new Name(this);
        }
    }
}
