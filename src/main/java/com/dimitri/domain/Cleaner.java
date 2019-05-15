package com.dimitri.domain;

import java.util.Objects;

public class Cleaner implements Comparable<Cleaner>{
    private String cleanerId;
    private String cleanerName;
    private String cleanerSurname;
    private String cleanerPhoneNr;
    private String cleanerEmail;

    private Cleaner(){}

    public String getCleanerId() {
        return cleanerId;
    }

    public String getCleanerName() {
        return cleanerName;
    }

    public String getCleanerSurname() {
        return cleanerSurname;
    }

    public String getCleanerPhoneNr() {
        return cleanerPhoneNr;
    }

    public String getCleanerEmail() {
        return cleanerEmail;
    }

    public Cleaner(Builder builder) {
        this.cleanerId = builder.cleanerId;
        this.cleanerName = builder.cleanerName;
        this.cleanerSurname = builder.cleanerSurname;
        this.cleanerPhoneNr = builder.cleanerPhoneNr;
        this.cleanerEmail = builder.cleanerEmail;
    }
    public static class Builder{

        String cleanerId;
        String cleanerName;
        String cleanerSurname;
        String cleanerPhoneNr;
        String cleanerEmail;

        public Builder cleanerId(String cleanerId){
            this.cleanerId = cleanerId;
            return this;
        }

        public Builder cleanerName(String cleanerName){
            this.cleanerName = cleanerName;
            return this;

        }

        public Builder cleanerSurname(String cleanerSurname){
            this.cleanerSurname = cleanerSurname;
            return this;
        }
        public Builder cleanerPhoneNr(String cleanerPhoneNr){
            this.cleanerPhoneNr = cleanerPhoneNr;
            return this;
        }
        public Builder cleanerEmail(String cleanerEmail){
            this.cleanerEmail = cleanerEmail;
            return this;
        }
        public Builder copy(Cleaner cleaner){
            this.cleanerId = cleaner.cleanerId;
            this.cleanerName = cleaner.cleanerName;
            this.cleanerSurname = cleaner.cleanerSurname;
            this.cleanerPhoneNr = cleaner.cleanerPhoneNr;
            this.cleanerEmail = cleaner.cleanerEmail;
            return this;
        }

        public Cleaner build() {
            return new Cleaner(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cleaner cleaner = (Cleaner) o;
        return Objects.equals(cleanerId, cleaner.cleanerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cleanerId);
    }

    @Override
    public int compareTo(Cleaner o) {
        return this.cleanerId.compareTo(o.cleanerId);
    }

    @Override
    public String toString() {
        return "Cleaner{" +
                "cleanerId='" + cleanerId + '\'' +
                ", cleanerName='" + cleanerName + '\'' +
                ", cleanerSurname='" + cleanerSurname + '\'' +
                ", cleanerPhoneNr='" + cleanerPhoneNr + '\'' +
                ", cleanerEmail='" + cleanerEmail + '\'' +
                '}';
    }
}

