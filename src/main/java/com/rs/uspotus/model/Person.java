package com.rs.uspotus.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter

@MappedSuperclass
public abstract class Person extends BaseEntity {
    @Column(name = "first_name")
    @JsonProperty("first_name")
    @NotNull
    @NotEmpty
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @NotEmpty
    @JsonProperty("last_name")
    private String lastName;

    @Column(name = "is_living")
    @JsonProperty("is_living")
    @NotNull(message = "is_living can't be null")
    private boolean isLiving;

    protected Person() {
    }

    protected Person(Long id, String firstName, String lastName, boolean isLiving) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.isLiving = isLiving;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isLiving=" + isLiving +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (isLiving != person.isLiving) return false;
        if (!Objects.equals(firstName, person.firstName)) return false;
        return Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (isLiving ? 1 : 0);
        return result;
    }

}
