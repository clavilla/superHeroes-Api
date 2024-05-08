package com.superhero.w2wchallenge.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuperHeroResponseDto {
    private Long id;
    private String name;
    private String power;
    private String universe;
}
