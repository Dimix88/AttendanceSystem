package com.dimitri.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Lecturer implements Comparable<Lecturer> {
    @Id
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

    @Override
    public int compareTo(Lecturer o) {
        return this.lecId.compareTo(o.lecId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecturer lecturer = (Lecturer) o;
        return lecId.equals(lecturer.lecId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lecId);
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
        public Builder copy(Lecturer lecturer){
            this.lecId = lecturer.lecId;
            this.firstName = lecturer.firstName;
            this.surname = lecturer.surname;
            this.phoneNumber = lecturer.phoneNumber;
            this.email = lecturer.email;
            return this;
        }

        public Lecturer build(){
            return new Lecturer(this);
        }
    }
}
