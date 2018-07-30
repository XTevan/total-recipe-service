package com.hilst.totalrecipeservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hilst.totalrecipeservice.exception.RecipeNotFoundException;
import com.hilst.totalrecipeservice.model.Recipe;
import com.hilst.totalrecipeservice.service.RecipeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.*;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value= RecipeController.class,secure = false)
public class RecipeControllerTest {
    private static final Long ID_RECIPE = 1l;
    private static final String NAME = "Milk Shake";
    private static final LocalDate CREATED_AT = LocalDate.of(2018,7,28);
    private static final boolean IS_VEGETARIAN = true;
    private static final String IMAGE_PATH = "";
    private static final int PORTION_SIZE = 1;
    private static final List<Object> INGREDIENTS  = new ArrayList<>();
    private static final List<String> INSTRUCTIONS = Arrays.asList("Pour milk into ice cream while mixing","Add chocolate");
    private static final Recipe RECIPE = new Recipe(ID_RECIPE, NAME, CREATED_AT, IS_VEGETARIAN, IMAGE_PATH, PORTION_SIZE,INGREDIENTS,INSTRUCTIONS);
    private static final List<Recipe> RECIPES = Collections.singletonList(RECIPE);

    private ObjectMapper serialiser;

    @Autowired
    private MockMvc mockMvc;

    public RecipeControllerTest() {
        serialiser = new ObjectMapper();
        serialiser.registerModule(new JavaTimeModule());
        serialiser.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    }

    @MockBean
    private RecipeService service;

    @Test
    public void findAllShouldCallServiceOnceAndReturn() throws Exception{
        when(service.findAll()).thenReturn(RECIPES);

        mockMvc.perform(get("/recipe")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(RECIPES.size())))
                .andExpect(jsonPath("$[0].id", is(ID_RECIPE.intValue())));
        verify(service, times(1)).findAll();
        verifyNoMoreInteractions(service);
    }

    @Test
    public void findOneShouldCallServiceOnceAndReturnModel() throws Exception {
        when(service.findById(ID_RECIPE)).thenReturn(RECIPE);

        mockMvc.perform(get("/recipe/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(ID_RECIPE.intValue())));
        verify(service, times(1)).findById(ID_RECIPE);
        verifyNoMoreInteractions(service);
    }

    @Test
    public void findOneShouldCallServiceOnceAndReturnNotFound() throws Exception {
        when(service.findById(ID_RECIPE)).thenThrow(new RecipeNotFoundException());

        mockMvc.perform(get("/recipe/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound());
        verify(service, times(1)).findById(ID_RECIPE);
        verifyNoMoreInteractions(service);
    }

    @Test
    public void saveShouldCallServiceOnceAndReturnModel() throws Exception {
        when(service.save(RECIPE)).thenReturn(RECIPE);
        String jsonBody = serialiser.writeValueAsString(RECIPE);


        mockMvc.perform(post("/recipe")
                .content(jsonBody)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isCreated());
        verify(service, times(1)).save(any(Recipe.class));
        verifyNoMoreInteractions(service);
    }

    @Test
    public void updateShouldCallServiceOnceAndReturnModel() throws Exception {
        when(service.update(RECIPE)).thenReturn(RECIPE);
        String jsonBody = serialiser.writeValueAsString(RECIPE);


        mockMvc.perform(put("/recipe/1")
                .content(jsonBody)
                .contentType(APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
        verify(service, times(1)).update(RECIPE);
        verifyNoMoreInteractions(service);
    }

    @Test
    public void updateShouldCallServiceOnceAndThrowError() throws Exception {
        when(service.update(RECIPE)).thenThrow(new RecipeNotFoundException());
        String jsonBody = serialiser.writeValueAsString(RECIPE);


        mockMvc.perform(put("/recipe/1")
                .content(jsonBody)
                .contentType(APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
        verify(service, times(1)).update(RECIPE);
        verifyNoMoreInteractions(service);
    }


}