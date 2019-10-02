package com.dimitri.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
@Entity
@Table(name = "Admins")
public class Admin implements Comparable<Admin>{
    @Id
    private String adminID;
    private String adminLevel;

    public Admin(){}

    public Admin(Builder builder){
        this.adminID = builder.adminID;
        this.adminLevel = builder.adminLevel;
    }

    public String getAdminID() {
        return adminID;
    }

    public String getAdminLevel() {
        return adminLevel;
    }
    public static class Builder{
        String adminID;
        String adminLevel;

        public Builder adminID(String adminID){
            this.adminID = adminID;
            return this;
        }
        public Builder adminLevel(String adminLevel){
            this.adminLevel = adminLevel;
            return this;
        }
        public Builder copy(Admin admin){
            this.adminID = admin.adminID;
            this.adminLevel = admin.adminLevel;

            return this;
        }
        public Admin build(){
            return new Admin(this);
        }
    }

    @Override
    public int compareTo(Admin o) {
        return this.adminID.compareTo(o.adminID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(adminID, admin.adminID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminID);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminID='" + adminID + '\'' +
                ", adminLevel='" + adminLevel + '\'' +
                '}';
    }
}
