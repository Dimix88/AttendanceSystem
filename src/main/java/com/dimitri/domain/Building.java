package com.dimitri.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Building implements Comparable<Building> {
    @Id
    private String bldgCode;
    private String bldgName;
    private String bldgLocation;

    public Building(){}

    public Building(Builder builder){
        this.bldgCode = builder.bldgCode;
        this.bldgName = builder.bldgName;
        this.bldgLocation = builder.bldgLocation;
    }
    public String getBldgCode() {
        return bldgCode;
    }

    public String getBldgName() {
        return bldgName;
    }

    public String getBldgLocation() {
        return bldgLocation;
    }
    public static class Builder{
        String bldgCode;
        String bldgName;
        String bldgLocation;

        public Builder bldgCode(String bldgCode){
            this.bldgCode = bldgCode;
            return this;
        }
        public Builder bldgName(String bldgName){
            this.bldgName = bldgName;
            return this;
        }
        public Builder bldgLocation(String bldgLocation){
            this.bldgLocation = bldgLocation;
            return this;
        }
        public Builder copy(Building building){
            this.bldgCode =building.bldgCode ;
            this.bldgName = building.bldgName;
            this.bldgLocation = building.bldgLocation;

            return this;
        }
        public Building build(){return new Building(this);}
    }

    @Override
    public int compareTo(Building o) {
        return this.bldgCode.compareTo(o.bldgCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return bldgCode.equals(building.bldgCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bldgCode);
    }
}
