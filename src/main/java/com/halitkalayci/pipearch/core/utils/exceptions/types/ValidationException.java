package com.halitkalayci.pipearch.core.utils.exceptions.types;

import com.halitkalayci.pipearch.core.application.pipelines.validation.ValidationError;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ValidationException extends RuntimeException{
  private List<ValidationError> errors;

  public ValidationException(List<ValidationError> errors) {
    this.errors = errors;
  }
}
