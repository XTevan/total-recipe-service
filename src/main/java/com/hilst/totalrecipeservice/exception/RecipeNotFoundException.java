package com.hilst.totalrecipeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "There is no recipe with the ID provided")
public class RecipeNotFoundException extends  RuntimeException{
}
