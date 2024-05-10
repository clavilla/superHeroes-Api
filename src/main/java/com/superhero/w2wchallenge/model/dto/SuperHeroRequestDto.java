package com.superhero.w2wchallenge.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuperHeroRequestDto {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;
    @NotBlank(message = "El poder no puede estar vacío")
    private String power;
    @NotBlank(message = "El universo no puede estar vacío")
    private String universe;

}
