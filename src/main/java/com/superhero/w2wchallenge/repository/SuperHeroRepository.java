package com.superhero.w2wchallenge.repository;

import com.superhero.w2wchallenge.model.entity.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface SuperHeroRepository extends JpaRepository<SuperHero, Long> {

    @NonNull
    List<SuperHero> findAll();

    @NonNull
    Optional<SuperHero> findById(@NonNull Long id);

    List<SuperHero> findByNameContaining(String name);

    void deleteById(@NonNull Long id);

}
