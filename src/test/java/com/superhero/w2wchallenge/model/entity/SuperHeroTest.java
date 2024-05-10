package com.superhero.w2wchallenge.model.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SuperHeroTest {

    @Test
    public void testGettersAndSetters() {
        SuperHero superHero = new SuperHero();
        superHero.setId(1L);
        superHero.setName("Test Hero");
        superHero.setPower("Test Power");
        superHero.setUniverse("Test Universe");

        assertEquals(1L, superHero.getId());
        assertEquals("Test Hero", superHero.getName());
        assertEquals("Test Power", superHero.getPower());
        assertEquals("Test Universe", superHero.getUniverse());
    }

    @Test
    public void testEqualsAndHashCode() {
        SuperHero superHero1 = new SuperHero(1L, "Test Hero", "Test Power", "Test Universe", null, null);
        SuperHero superHero2 = new SuperHero(1L, "Test Hero", "Test Power", "Test Universe", null, null);

        assertTrue(superHero1.equals(superHero2) && superHero2.equals(superHero1));
        assertEquals(superHero1.hashCode(), superHero2.hashCode());
    }

    @Test
    public void testToString() {
        SuperHero superHero = new SuperHero(1L, "Test Hero", "Test Power", "Test Universe", null, null);
        String expected = "SuperHero(id=1, name=Test Hero, power=Test Power, universe=Test Universe, createdAt=null, updatedAt=null)";
        assertEquals(expected, superHero.toString());
    }
}