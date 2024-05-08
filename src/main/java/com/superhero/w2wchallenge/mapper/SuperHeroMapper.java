package com.superhero.w2wchallenge.mapper;

import com.superhero.w2wchallenge.model.dto.SuperHeroRequestDto;
import com.superhero.w2wchallenge.model.dto.SuperHeroResponseDto;
import com.superhero.w2wchallenge.model.entity.SuperHero;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SuperHeroMapper {

    private final ModelMapper modelMapper;

    public SuperHeroMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public SuperHero convertToEntity(SuperHeroRequestDto superHeroRequestDto) {
        return modelMapper.map(superHeroRequestDto, SuperHero.class);
    }

    public SuperHeroResponseDto convertToDto(SuperHero superHero) {
        return modelMapper.map(superHero, SuperHeroResponseDto.class);
    }

    public List<SuperHeroResponseDto> convertToListDto(List<SuperHero> superHeroList) {
        return superHeroList.stream().map(this::convertToDto).toList();
    }

}
