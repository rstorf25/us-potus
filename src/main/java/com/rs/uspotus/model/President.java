package com.rs.uspotus.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "presidents")
public class President extends Person {
    @Column(name = "terms_served")
    @JsonProperty("terms_served")
    private Long termsServed;

    @Column(name = "years_served")
    @JsonProperty("years_served")
    private Long yearsServed;

    public President() {
    }

    public President(String firstName, String lastName, boolean isLiving, Long termsServed, Long yearsServed) {
        super(firstName, lastName, isLiving);
        this.termsServed = termsServed;
        this.yearsServed = yearsServed;
    }


    public Long getTermsServed() {
        return termsServed;
    }

    public void setTermsServed(Long termsServed) {
        this.termsServed = termsServed;
    }

    public Long getYearsServed() {
        return yearsServed;
    }

    public void setYearsServed(Long yearsServed) {
        this.yearsServed = yearsServed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        President president = (President) o;

        if (!Objects.equals(termsServed, president.termsServed))
            return false;
        return Objects.equals(yearsServed, president.yearsServed);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (termsServed != null ? termsServed.hashCode() : 0);
        result = 31 * result + (yearsServed != null ? yearsServed.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "President{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", isLiving=" + isLiving() +
                ", termsServed=" + termsServed +
                ", yearsServed=" + yearsServed +
                '}';
    }



}
