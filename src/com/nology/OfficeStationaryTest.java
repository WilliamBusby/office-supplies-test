package com.nology;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OfficeStationaryTest {

    private Pen pens;
    private Ruler rulers;
    private Booklet booklets;
    private Stapler stapler;
    private Staples staples;

    @BeforeEach
    void setUp() {
        this.pens = new Pen(1000);
        this.rulers = new Ruler(50);
        this.booklets = new Booklet(300);
        this.stapler = new Stapler(200,8000);
        this.staples = new Staples(8000);
    }

    @AfterEach
    void tearDown() {}

    @Test
    public void removingPensFromSupply() {
        String response = pens.removeFromSupply(258);
        assertEquals("Removed 258 from supply. Remaining: 742", response);
    }

    @Test
    public void pensNeededToAcquire() {
        String response = pens.removeFromSupply(2500);
        assertEquals("You don't have enough for that, need another 1500", response);
    }

    @Test
    public void staplesPerStapler() {
        int maxStaplesPerStapler = stapler.staplesPerStapler();
        assertTrue(92 >= maxStaplesPerStapler);
    }

    @Test
    public void misplacedRulers() {
        String response = rulers.removeFromSupply(63);
        assertEquals("You don't have enough for that, need another 13", response);
    }

    @Test
    public void totalSuppliesPerPerson() {
        int peoplePens = pens.totalStaffFromSupply(5);
        int peopleRulers = rulers.totalStaffFromSupply(3);
        int peopleBooklets = booklets.totalStaffFromSupply(4);
        int peopleStaplers = stapler.totalStaffFromSupply(1);
        int peopleStaples = staples.totalStaffFromSupply(100);

        int maxPeople =  Math.min(Math.min(peopleBooklets, peoplePens), Math.min(Math.min(peopleStaples, peopleStaplers), peopleRulers));
        assertEquals(maxPeople, 16);
    }
}
