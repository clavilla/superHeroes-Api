package com.superhero.w2wchallenge.model.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SuperHeroRequestDtoTest {

    @Test
    public void testGettersAndSetters() {
        SuperHeroRequestDto superHeroDto = new SuperHeroRequestDto();
        superHeroDto.setName("Test Hero");
        superHeroDto.setPower("Test Power");
        superHeroDto.setUniverse("Test Universe");

        assertEquals("Test Hero", superHeroDto.getName());
        assertEquals("Test Power", superHeroDto.getPower());
        assertEquals("Test Universe", superHeroDto.getUniverse());
    }

    @Test
    public void testEqualsAndHashCode() {
        SuperHeroRequestDto superHeroDto1 = new SuperHeroRequestDto("Test Hero", "Test Power", "Test Universe");
        SuperHeroRequestDto superHeroDto2 = new SuperHeroRequestDto("Test Hero", "Test Power", "Test Universe");

        assertTrue(superHeroDto1.equals(superHeroDto2) && superHeroDto2.equals(superHeroDto1));
        assertEquals(superHeroDto1.hashCode(), superHeroDto2.hashCode());
    }

    @Test
    public void testToString() {
        SuperHeroRequestDto superHeroDto = new SuperHeroRequestDto("Test Hero", "Test Power", "Test Universe");
        String expected = "SuperHeroRequestDto(name=Test Hero, power=Test Power, universe=Test Universe)";
        assertEquals(expected, superHeroDto.toString());
    }
}