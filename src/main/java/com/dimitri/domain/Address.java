package com.dimitri.domain;

public class Address {
    String streetAddres;
    String postalAddress;
    String city;
    String province;

    public Address(){}

    public Address(Builder builder){
        this.streetAddres = builder.streetAddres;
        this.postalAddress = builder.postalAddress;
        this.city = builder.city;
        this.province = builder.province;

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
        String streetAddres;
        String postalAddress;
        String city;
        String province;

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
            this.streetAddres = address.streetAddres;
            this.postalAddress = address.postalAddress;
            this.city = address.city;
            this.province = address.province;
            return this;
        }
        public Address build(){return new Address(this);}
    }
}
