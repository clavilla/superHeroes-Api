package com.superhero.w2wchallenge.service;

import com.superhero.w2wchallenge.exception.ResourceNotFoundException;
import com.superhero.w2wchallenge.mapper.SuperHeroMapper;
import com.superhero.w2wchallenge.model.dto.SuperHeroRequestDto;
import com.superhero.w2wchallenge.model.dto.SuperHeroResponseDto;
import com.superhero.w2wchallenge.model.entity.SuperHero;
import com.superhero.w2wchallenge.repository.SuperHeroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class SuperHeroServiceTest {

    @InjectMocks
    private SuperHeroService superHeroService;

    @Mock
    private SuperHeroRepository superHeroRepository;

    @Mock
    private SuperHeroMapper superHeroMapper;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        SuperHero superHero = new SuperHero();
        SuperHeroResponseDto superHeroResponseDto = new SuperHeroResponseDto();
        when(superHeroRepository.findAll()).thenReturn(Arrays.asList(superHero));
        when(superHeroMapper.convertToListDto(Arrays.asList(superHero))).thenReturn(Arrays.asList(superHeroResponseDto));

        List<SuperHeroResponseDto> result = superHeroService.findAll();

        assertEquals(1, result.size());
        verify(superHeroRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        SuperHero superHero = new SuperHero();
        SuperHeroResponseDto superHeroResponseDto = new SuperHeroResponseDto();
        when(superHeroRepository.findById(1L)).thenReturn(Optional.of(superHero));
        when(superHeroMapper.convertToDto(superHero)).thenReturn(superHeroResponseDto);

        SuperHeroResponseDto result = superHeroService.findById(1L);

        assertEquals(superHeroResponseDto, result);
        verify(superHeroRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindByIdNotFound() {
        when(superHeroRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> superHeroService.findById(1L));
        verify(superHeroRepository, times(1)).findById(1L);
    }

    // Similar tests can be written for other methods
    @Test
    public void testFindByNameContainingIgnoreCase() {
        SuperHero superHero = new SuperHero();
        SuperHeroResponseDto superHeroResponseDto = new SuperHeroResponseDto();
        when(superHeroRepository.findByNameContainingIgnoreCase("man")).thenReturn(Arrays.asList(superHero));
        when(superHeroMapper.convertToListDto(Arrays.asList(superHero))).thenReturn(Arrays.asList(superHeroResponseDto));

        List<SuperHeroResponseDto> result = superHeroService.findByNameContainingIgnoreCase("man");

        assertEquals(1, result.size());
        verify(superHeroRepository, times(1)).findByNameContainingIgnoreCase("man");
    }

    @Test
    public void testCreate() {
        SuperHeroRequestDto superHeroRequestDto = new SuperHeroRequestDto();
        SuperHero superHero = new SuperHero();
        SuperHeroResponseDto superHeroResponseDto = new SuperHeroResponseDto();
        when(superHeroMapper.convertToEntity(superHeroRequestDto)).thenReturn(superHero);
        when(superHeroRepository.save(superHero)).thenReturn(superHero);
        when(superHeroMapper.convertToDto(superHero)).thenReturn(superHeroResponseDto);

        SuperHeroResponseDto result = superHeroService.create(superHeroRequestDto);

        assertEquals(superHeroResponseDto, result);
        verify(superHeroRepository, times(1)).save(superHero);
    }

    @Test
    public void testUpdate() {
        SuperHeroRequestDto superHeroRequestDto = new SuperHeroRequestDto();
        SuperHero superHero = new SuperHero();
        SuperHeroResponseDto superHeroResponseDto = new SuperHeroResponseDto();
        when(superHeroRepository.findById(1L)).thenReturn(Optional.of(superHero));
        when(superHeroRepository.save(superHero)).thenReturn(superHero);
        when(superHeroMapper.convertToDto(superHero)).thenReturn(superHeroResponseDto);

        SuperHeroResponseDto result = superHeroService.update(1L, superHeroRequestDto);

        assertEquals(superHeroResponseDto, result);
        verify(superHeroRepository, times(1)).save(superHero);
    }

    @Test
    public void testDeleteById() {
        doNothing().when(superHeroRepository).deleteById(1L);

        superHeroService.deleteById(1L);

        verify(superHeroRepository, times(1)).deleteById(1L);
    }
}