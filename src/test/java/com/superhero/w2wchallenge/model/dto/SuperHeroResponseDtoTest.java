package com.superhero.w2wchallenge.model.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SuperHeroResponseDtoTest {

    @Test
    public void testGettersAndSetters() {
        SuperHeroResponseDto superHeroDto = new SuperHeroResponseDto();
        superHeroDto.setId(1L);
        superHeroDto.setName("Test Hero");
        superHeroDto.setPower("Test Power");
        superHeroDto.setUniverse("Test Universe");

        assertEquals(1L, superHeroDto.getId());
        assertEquals("Test Hero", superHeroDto.getName());
        assertEquals("Test Power", superHeroDto.getPower());
        assertEquals("Test Universe", superHeroDto.getUniverse());
    }

    @Test
    public void testEqualsAndHashCode() {
        SuperHeroResponseDto superHeroDto1 = new SuperHeroResponseDto(1L, "Test Hero", "Test Power", "Test Universe");
        SuperHeroResponseDto superHeroDto2 = new SuperHeroResponseDto(1L, "Test Hero", "Test Power", "Test Universe");

        assertTrue(superHeroDto1.equals(superHeroDto2) && superHeroDto2.equals(superHeroDto1));
        assertEquals(superHeroDto1.hashCode(), superHeroDto2.hashCode());
    }

    @Test
    public void testToString() {
        SuperHeroResponseDto superHeroDto = new SuperHeroResponseDto(1L, "Test Hero", "Test Power", "Test Universe");
        String expected = "SuperHeroResponseDto(id=1, name=Test Hero, power=Test Power, universe=Test Universe)";
        assertEquals(expected, superHeroDto.toString());
    }
}