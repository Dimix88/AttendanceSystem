package com.dimitri.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Security implements Comparable<Security.Builder> {
    @Id
    private String securityId;
    private String securityName;
    private String securitySurname;
    private String securityPhoneNr;
    private String securityEmail;

    public Security(){}

    public Security(Builder builder) {
        this.securityId = builder.securityId;
        this.securityName = builder.securityName;
        this.securitySurname = builder.securitySurname;
        this.securityPhoneNr = builder.securityPhoneNr;
        this.securityEmail = builder.securityEmail;
    }

    public String getSecurityId() {
        return securityId;
    }

    public String getSecurityName() {
        return securityName;
    }

    public String getSecuritySurname() {
        return securitySurname;
    }

    public String getSecurityPhoneNr() {
        return securityPhoneNr;
    }

    public String getSecurityEmail() {
        return securityEmail;
    }
    public static class Builder{

        String securityId;
        String securityName;
        String securitySurname;
        String securityPhoneNr;
        String securityEmail;

        public Builder securityId(String securityId){
            this.securityId = securityId;
            return this;
        }
        public Builder securityName(String securityName){
            this.securityName = securityName;
            return this;

        }
        public Builder securitySurname(String securitySurname){
            this.securitySurname = securitySurname;
            return this;
        }
        public Builder securityPhoneNr(String securityPhoneNr){
            this.securityPhoneNr = securityPhoneNr;
            return this;
        }
        public Builder securityEmail(String securityEmail){
            this.securityEmail = securityEmail;
            return this;
        }
        public Builder copy(Security security){
            this.securityId = security.securityId;
            this.securityName = security.securityName;
            this.securitySurname = security.securitySurname;
            this.securityPhoneNr = security.securityPhoneNr;
            this.securityEmail = security.securityEmail;
            return this;
        }

        public Security build() {
            return new Security(this);
        }
    }
    @Override
    public int compareTo(Builder o) {
        return this.securityId.compareTo(o.securityId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Security security = (Security) o;
        return Objects.equals(securityId, security.securityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(securityId);
    }

    @Override
    public String toString() {
        return "Security{" +
                "securityId='" + securityId + '\'' +
                ", securityName='" + securityName + '\'' +
                ", securitySurname='" + securitySurname + '\'' +
                ", securityPhoneNr='" + securityPhoneNr + '\'' +
                ", securityEmail='" + securityEmail + '\'' +
                '}';
    }
}
