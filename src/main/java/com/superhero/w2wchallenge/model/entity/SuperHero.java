package com.superhero.w2wchallenge.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "superheroes")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @CreationTimestamp
    @Column(name="created_at")
    private LocalDate createdAt;
    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDate updatedAt;
}
