package com.dimitri.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Department implements Comparable<Department> {
    @Id
    private String deptCode;
    private String deptName;
    private String schoolName;
    private String lecId;

    public Department(){}

    public Department(Builder builder){
        this.deptCode = builder.deptCode;
        this.deptName = builder.deptName;
        this.schoolName = builder.schoolName;
        this.lecId = builder.lecId;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getLecId() {
        return lecId;
    }

    @Override
    public int compareTo(Department o) {
        return this.deptCode.compareTo(o.deptCode);
    }

    public static class Builder{
        String deptCode;
        String deptName;
        String schoolName;
        String lecId;

        public Builder deptCode(String deptCode){
            this.deptCode = deptCode;
            return this;
        }
        public Builder deptName(String deptName){
            this.deptName = deptName;
            return this;
        }
        public Builder schoolName(String schoolName){
            this.schoolName = schoolName;
            return  this;
        }
        public Builder lecId(String lecId){
            this.lecId = lecId;
            return this;
        }
        public Builder copy(Department department){
            this.deptCode = department.deptCode;
            this.deptName = department.deptName;
            this.schoolName = department.schoolName;
            this.lecId = department.lecId;

            return this;
        }
        public Department build(){ return new Department(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return deptCode.equals(that.deptCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptCode);
    }
}
