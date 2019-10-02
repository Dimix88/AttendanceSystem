package com.dimitri.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Address implements Comparable<Address> {

    @Id
    private String addressCode;
    private String streetAddres;
    private String postalAddress;
    private String city;
    private String province;

    public Address(){}

    public Address(Builder builder){
        this.addressCode = builder.addressCode;
        this.streetAddres = builder.streetAddres;
        this.postalAddress = builder.postalAddress;
        this.city = builder.city;
        this.province = builder.province;

    }

    public String getAddressCode() {
        return addressCode;
    }

    public String getStreetAddres() {
        return streetAddres;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public static class Builder{
        String addressCode;
        String streetAddres;
        String postalAddress;
        String city;
        String province;

        public Builder addressCode(String addressCode){
            this.addressCode = addressCode;
            return this;
        }

        public Builder streetAddress(String streetAddres){
            this.streetAddres = streetAddres;
            return this;
        }
        public Builder postalAddress(String postalAddress){
            this.postalAddress = postalAddress;
            return this;
        }
        public Builder city(String city){
            this.city = city;
            return this;
        }
        public Builder province(String province){
            this.province = province;
            return this;
        }
        public Builder copy(Address address){
            this.addressCode = address.addressCode;
            this.streetAddres = address.streetAddres;
            this.postalAddress = address.postalAddress;
            this.city = address.city;
            this.province = address.province;
            return this;
        }
        public Address build(){return new Address(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return addressCode.equals(address.addressCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressCode);
    }

    @Override
    public int compareTo(Address o) {
        return this.addressCode.compareTo(o.addressCode);
    }
}
