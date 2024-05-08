package com.superhero.w2wchallenge.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "superheros")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SuperHero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="power")
    private String power;
    @Column(name="universe")
    private String universe;
    @Column(name="created_at")
    private LocalDate createdAt;
    @Column(name="updated_at")
    private LocalDate updatedAt;

}
