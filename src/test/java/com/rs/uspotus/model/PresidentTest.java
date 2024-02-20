package com.rs.uspotus.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PresidentTest {
    President president;

    @BeforeEach
    public void setUp() {
        president = new President();
    }

    @Test
    void getTermsServed() {
        Long termServed = 4L;
        president.setTermsServed(termServed);

        assertEquals(termServed, president.getTermsServed());
    }

    @Test
    void getYearsServed() {
        Long yearsServed = 3L;
        president.setYearsServed(yearsServed);

        assertEquals(yearsServed, president.getYearsServed());
    }

    @Test
    void getIdTest() {
        Long id = 1L;
        president.setId(id);

        assertEquals(id, president.getId());
    }

    @Test
    void getFirstNameTest() {
        String firstName = "John";
        president.setFirstName(firstName);

        assertEquals(firstName, president.getFirstName());
    }

    @Test
    void getLastNameTest() {
        String lastName = "Test";
        president.setLastName(lastName);

        assertEquals(lastName, president.getLastName());
    }

    @Test
    void isLivingTest(){
        boolean living = true;
        president.setLiving(living);

        assertEquals(living, president.isLiving());
    }
}