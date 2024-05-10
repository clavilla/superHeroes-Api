package com.superhero.w2wchallenge.controller;

import com.superhero.w2wchallenge.model.dto.SuperHeroRequestDto;
import com.superhero.w2wchallenge.model.dto.SuperHeroResponseDto;
import com.superhero.w2wchallenge.service.SuperHeroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SuperHeroControllerTest {

    @InjectMocks
    SuperHeroController superHeroController;

    @Mock
    SuperHeroService superHeroService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllSuperHeroes() {
        SuperHeroResponseDto superHero = new SuperHeroResponseDto();
        when(superHeroService.findAll()).thenReturn(Arrays.asList(superHero));

        ResponseEntity<List<SuperHeroResponseDto>> response = superHeroController.getAllSuperHeroes();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(superHeroService, times(1)).findAll();
    }

    @Test
    public void testGetSuperHeroById() {
        SuperHeroResponseDto superHero = new SuperHeroResponseDto();
        when(superHeroService.findById(anyLong())).thenReturn(superHero);

        ResponseEntity<SuperHeroResponseDto> response = superHeroController.getSuperHeroById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(superHeroService, times(1)).findById(anyLong());
    }

    @Test
    public void testGetSuperHeroByNameContaining() {
        SuperHeroResponseDto superHero = new SuperHeroResponseDto();
        when(superHeroService.findByNameContainingIgnoreCase(anyString())).thenReturn(Arrays.asList(superHero));

        ResponseEntity<List<SuperHeroResponseDto>> response = superHeroController.getSuperHeroByNameContaining("name");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(superHeroService, times(1)).findByNameContainingIgnoreCase(anyString());
    }

    @Test
    public void testCreateSuperHero() {
        SuperHeroRequestDto requestDto = new SuperHeroRequestDto();
        SuperHeroResponseDto responseDto = new SuperHeroResponseDto();
        when(superHeroService.create(any(SuperHeroRequestDto.class))).thenReturn(responseDto);

        ResponseEntity<SuperHeroResponseDto> response = superHeroController.createSuperHero(requestDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(superHeroService, times(1)).create(any(SuperHeroRequestDto.class));
    }

    @Test
    public void testUpdateSuperHero() {
        SuperHeroRequestDto requestDto = new SuperHeroRequestDto();
        SuperHeroResponseDto responseDto = new SuperHeroResponseDto();
        when(superHeroService.update(anyLong(), any(SuperHeroRequestDto.class))).thenReturn(responseDto);

        ResponseEntity<SuperHeroResponseDto> response = superHeroController.updateSuperHero(1L, requestDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(superHeroService, times(1)).update(anyLong(), any(SuperHeroRequestDto.class));
    }

    @Test
    public void testDeleteSuperHero() {
        doNothing().when(superHeroService).deleteById(anyLong());

        ResponseEntity<Void> response = superHeroController.deleteSuperHero(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(superHeroService, times(1)).deleteById(anyLong());
    }
}