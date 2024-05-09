package com.superhero.w2wchallenge.service;

import com.superhero.w2wchallenge.exception.ResourceNotFoundException;
import com.superhero.w2wchallenge.mapper.SuperHeroMapper;
import com.superhero.w2wchallenge.model.dto.SuperHeroRequestDto;
import com.superhero.w2wchallenge.model.dto.SuperHeroResponseDto;
import com.superhero.w2wchallenge.model.entity.SuperHero;
import com.superhero.w2wchallenge.repository.SuperHeroRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SuperHeroService {

    private final SuperHeroRepository superHeroRepository;
    private final SuperHeroMapper superHeroMapper;

    public SuperHeroService(SuperHeroRepository superHeroRepository, SuperHeroMapper superHeroMapper) {
        this.superHeroRepository = superHeroRepository;
        this.superHeroMapper = superHeroMapper;
    }

    @NonNull
    @Transactional(readOnly = true)
    public List<SuperHeroResponseDto> findAll() {
        List<SuperHero> superHeroList = superHeroRepository.findAll();
        return superHeroMapper.convertToListDto(superHeroList);
    }

    @NonNull
    @Transactional(readOnly = true)
    public SuperHeroResponseDto findById(@NonNull Long id) {
        SuperHero superHero = superHeroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SuperHero not found with id: " + id));
        return superHeroMapper.convertToDto(superHero);
    }

    @Transactional(readOnly = true)
    public List<SuperHeroResponseDto> findByNameContaining(String name) {
        List<SuperHero> superHeroList = superHeroRepository.findByNameContaining(name);
        return superHeroMapper.convertToListDto(superHeroList);
    }

    @Transactional
    public SuperHeroResponseDto create(SuperHeroRequestDto superHeroRequestDto) {
        SuperHero superHero = superHeroMapper.convertToEntity(superHeroRequestDto);
        superHero.setCreatedAt(LocalDate.now());
        superHero = superHeroRepository.save(superHero);
        return superHeroMapper.convertToDto(superHero);
    }

    @Transactional
    public SuperHeroResponseDto update(Long id, SuperHeroRequestDto superHeroRequestDto) {
        SuperHero superHero = superHeroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SuperHero not found with id: " + id));
        superHero.setName(superHeroRequestDto.getName());
        superHero.setPower(superHeroRequestDto.getPower());
        superHero.setUniverse(superHeroRequestDto.getUniverse());
        superHero.setUpdatedAt(LocalDate.now());
        return superHeroMapper.convertToDto(superHeroRepository.save(superHero));
    }

    @Transactional
    public void deleteById(@NonNull Long id) {
        superHeroRepository.deleteById(id);
    }
}
