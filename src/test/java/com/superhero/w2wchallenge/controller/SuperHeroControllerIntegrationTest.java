package com.superhero.w2wchallenge.controller;

import com.superhero.w2wchallenge.model.dto.SuperHeroResponseDto;
import com.superhero.w2wchallenge.service.SuperHeroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class SuperHeroControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SuperHeroService superHeroService;

    @BeforeEach
    public void setup() {
        SuperHeroResponseDto superHeroDto = new SuperHeroResponseDto();
        superHeroDto.setName("Test Hero");
        superHeroDto.setPower("Test Power");
        superHeroDto.setUniverse("Test Universe");
        Mockito.when(superHeroService.findById(1L)).thenReturn(superHeroDto);
    }

    @Test
    @WithMockUser(username = "admin")
    public void testGetAllSuperHeroes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/superHeroes/getAllSuperHeroes"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithMockUser(username = "admin")
    public void testGetSuperHeroById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/superHeroes/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithMockUser(username = "admin")
    public void testCreateSuperHero() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/superHeroes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test Hero\",\"power\":\"Test Power\",\"universe\":\"Test Universe\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @WithMockUser(username = "admin")
    public void testUpdateSuperHero() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/superHeroes/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Updated Hero\",\"power\":\"Updated Power\",\"universe\":\"Updated Universe\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithMockUser(username = "admin")
    public void testDeleteSuperHero() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/superHeroes/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
