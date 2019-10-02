package com.dimitri.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class ImportantDates implements Comparable<ImportantDates> {
    @Id
    private String importantDatesCode;
    private String sDate;
    private String eDate;

    public ImportantDates(){}

    public ImportantDates(Builder builder){
        this.importantDatesCode = builder.importantDatesCode;
        this.sDate = builder.sDate;
        this.eDate = builder.eDate;
    }

    public String getImportantDatesCode() {
        return importantDatesCode;
    }

    public String getsDate() {
        return sDate;
    }

    public String geteDate() {
        return eDate;
    }
    public static class Builder{
        String importantDatesCode;
        String sDate;
        String eDate;

        public Builder importantDatesCode(String importantDatesCode){
            this.importantDatesCode = importantDatesCode;
            return this;
        }
        public Builder sDate(String sDate){
            this.sDate = sDate;
            return this;
        }
        public Builder eDate(String eDate){
            this.eDate = eDate;
            return this;
        }
        public Builder copy(ImportantDates importantDates){
            this.importantDatesCode = importantDates.importantDatesCode;
            this.sDate = importantDates.sDate;
            this.eDate = importantDates.eDate;

            return this;
        }
        public ImportantDates build(){
            return new ImportantDates(this);
        }
    }
    @Override
    public int compareTo(ImportantDates o) {
        return this.sDate.compareTo(o.sDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImportantDates that = (ImportantDates) o;
        return Objects.equals(sDate, that.sDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sDate);
    }
}
