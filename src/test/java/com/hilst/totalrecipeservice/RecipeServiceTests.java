package com.hilst.totalrecipeservice;

import com.hilst.totalrecipeservice.exception.RecipeNotFoundException;
import com.hilst.totalrecipeservice.model.Recipe;
import com.hilst.totalrecipeservice.repository.RecipeRepository;
import com.hilst.totalrecipeservice.service.RecipeService;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class RecipeServiceTests {
	private static final Long ID_RECIPE = 1l;
	private static final String NAME = "Milk Shake";
	private static final LocalDate CREATEDIN = LocalDate.of(2018,7,28);
	private static final boolean ISVEGETARIAN = true;
	private static final String IMAGEPATH = "";
	private static final int PORTIONSIZE = 1;
	private static final List<String> INGREDIENTS  = Arrays.asList("Milk", "Ice Cream", "Chocolate");
	private static final List<String> INSTRUCTIONS = Arrays.asList("Pour milk into ice cream while mixing","Add chocolate");
	private static final Recipe RECIPE = new Recipe(ID_RECIPE, NAME,CREATEDIN,ISVEGETARIAN,IMAGEPATH,PORTIONSIZE,INGREDIENTS,INSTRUCTIONS);
	private static final List<Recipe> RECIPES = Collections.singletonList(RECIPE);


	@Mock
	private RecipeRepository repository;

	@InjectMocks
	private RecipeService service;

	@Test
	public void findAllShouldCallRepositoryOnce() {
		when(repository.findAll()).thenReturn(RECIPES);

		List<Recipe> result = service.findAll();

		Assert.assertEquals(result.size(),RECIPES.size());
		verify(repository, times(1)).findAll();
		verifyNoMoreInteractions(repository);
	}

	@Test
	public void findByIdShouldCallRepositoryOnceAndReturnModel() {
		when(repository.findById(ID_RECIPE)).thenReturn(Optional.of(RECIPE));

		Optional<Recipe> result = service.findById(ID_RECIPE);

		Assert.assertTrue(result.isPresent());
		Assert.assertTrue(result.get().equals(RECIPE));
		verify(repository, times(1)).findById(ID_RECIPE);
		verifyNoMoreInteractions(repository);
	}


	@Test
	public void findByIdShouldCallRepositoryOnceAndReturnEmptyModel() {
		when(repository.findById(ID_RECIPE)).thenReturn(Optional.empty());

		Optional<Recipe> result = service.findById(ID_RECIPE);

		Assert.assertFalse(result.isPresent());
		verify(repository, times(1)).findById(ID_RECIPE);
		verifyNoMoreInteractions(repository);
	}

	@Test
	public void saveShouldCallRepositoryOnceAndReturnModel() {
		when(repository.save(RECIPE)).thenReturn(RECIPE);

		Recipe result = service.save(RECIPE);

		Assert.assertNotNull(result);
		Assert.assertEquals(result.toString(),RECIPE.toString());
		verify(repository,times(1)).save(RECIPE);
		verifyNoMoreInteractions(repository);
	}

	@Test
	public void updateShouldCallRepositoryOnceAndReturnModel() {
		when(repository.save(RECIPE)).thenReturn(RECIPE);
		when(repository.findById(ID_RECIPE)).thenReturn(Optional.of(RECIPE));

		Recipe result = service.update(RECIPE);

		Assert.assertNotNull(result);
		Assert.assertEquals(result.toString(),RECIPE.toString());
		verify(repository, times(1)).findById(ID_RECIPE);
		verify(repository,times(1)).save(RECIPE);
		verifyNoMoreInteractions(repository);
	}


	@Test(expected= RecipeNotFoundException.class)
	public void updateShouldCallRepositoryOnceAndThrowError() {
		when(repository.findById(ID_RECIPE)).thenReturn(Optional.empty());

		service.update(RECIPE);
		verify(repository,times(0)).save(RECIPE);
		verifyNoMoreInteractions(repository);
	}

}
