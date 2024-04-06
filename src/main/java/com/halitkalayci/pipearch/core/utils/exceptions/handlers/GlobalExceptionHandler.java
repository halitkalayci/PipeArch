package com.halitkalayci.pipearch.core.utils.exceptions.handlers;

import com.halitkalayci.pipearch.core.utils.exceptions.problemDetails.custom.NotAuthenticatedProblemDetails;
import com.halitkalayci.pipearch.core.utils.exceptions.problemDetails.custom.NotAuthorizedProblemDetails;
import com.halitkalayci.pipearch.core.utils.exceptions.problemDetails.custom.ValidationProblemDetails;
import com.halitkalayci.pipearch.core.utils.exceptions.types.NotAuthenticatedException;
import com.halitkalayci.pipearch.core.utils.exceptions.types.NotAuthorizedException;
import com.halitkalayci.pipearch.core.utils.exceptions.types.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({NotAuthenticatedException.class})
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public NotAuthenticatedProblemDetails handleAuthenticationException(NotAuthenticatedException exception){
    return new NotAuthenticatedProblemDetails();
  }

  @ExceptionHandler({NotAuthorizedException.class})
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public NotAuthorizedProblemDetails handleAuthorizeException(NotAuthorizedException exception)
  {
    return new NotAuthorizedProblemDetails();
  }

  @ExceptionHandler({ValidationException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ValidationProblemDetails handleValidationException(ValidationException exception)
  {
    return new ValidationProblemDetails(exception.getErrors());
  }
}
