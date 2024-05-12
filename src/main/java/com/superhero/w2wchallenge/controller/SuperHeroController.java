package com.superhero.w2wchallenge.controller;

import com.superhero.w2wchallenge.model.dto.SuperHeroRequestDto;
import com.superhero.w2wchallenge.model.dto.SuperHeroResponseDto;
import com.superhero.w2wchallenge.service.SuperHeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/superHeroes")
public class SuperHeroController {

    private final SuperHeroService superHeroService;

    public SuperHeroController(SuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }

    @GetMapping("/getAllSuperHeroes")
    public ResponseEntity<List<SuperHeroResponseDto>> getAllSuperHeroes() {
        List <SuperHeroResponseDto> superHeroes = superHeroService.findAll();
        return new ResponseEntity<>(superHeroes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuperHeroResponseDto> getSuperHeroById(@PathVariable Long id) {
        SuperHeroResponseDto superHero = superHeroService.findById(id);
        return new ResponseEntity<>(superHero, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<SuperHeroResponseDto>> getSuperHeroByNameContaining(@RequestParam String name) {
        List <SuperHeroResponseDto> superHeroes = superHeroService.findByNameContainingIgnoreCase(name.toLowerCase());
        return new ResponseEntity<>(superHeroes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SuperHeroResponseDto> createSuperHero(
            @Validated @RequestBody SuperHeroRequestDto superHeroDto) {
        SuperHeroResponseDto newSuperHero = superHeroService.create(superHeroDto);
        return new ResponseEntity<>(newSuperHero, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuperHeroResponseDto> updateSuperHero(
            @PathVariable Long id, @Validated @RequestBody SuperHeroRequestDto superHeroDto) {
        SuperHeroResponseDto updatedSuperHero = superHeroService.update(id, superHeroDto);
        return new ResponseEntity<>(updatedSuperHero, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSuperHero(@PathVariable Long id) {
        superHeroService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
