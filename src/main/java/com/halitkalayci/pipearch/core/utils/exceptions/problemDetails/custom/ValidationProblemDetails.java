package com.halitkalayci.pipearch.core.utils.exceptions.problemDetails.custom;

import com.halitkalayci.pipearch.core.application.pipelines.validation.ValidationError;
import com.halitkalayci.pipearch.core.utils.exceptions.problemDetails.ProblemDetails;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ValidationProblemDetails extends ProblemDetails {
  private List<ValidationError> errors;

  public ValidationProblemDetails(List<ValidationError> errors) {
    super("Validation Violation", "You have invalid fields.", "ValidationException");
    this.errors = errors;
  }
}
