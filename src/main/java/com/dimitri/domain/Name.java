package com.dimitri.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Name {
    @Id
    private String nameCode;
    private String firstName;
    private String middleName;
    private String lastName;

    public Name(){}

    public Name(Builder builder){
        this.nameCode = builder.nameCode;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;

    }

    public String getNameCode() {
        return nameCode;
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
        String nameCode;
        String firstName;
        String middleName;
        String lastName;

        public Builder nameCode(String nameCode){
            this.nameCode = nameCode;
            return this;
        }
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
        public Builder copy(Name name){
            this.nameCode = name.nameCode;
            this.firstName = name.firstName;
            this.middleName = name.middleName;
            this.lastName = name.lastName;

            return this;
        }
        public Name build(){
            return new Name(this);
        }
    }
}
