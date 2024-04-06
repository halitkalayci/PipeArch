package com.halitkalayci.pipearch.core.utils.exceptions.problemDetails.custom;

import com.halitkalayci.pipearch.core.utils.exceptions.problemDetails.ProblemDetails;

public class NotAuthenticatedProblemDetails extends ProblemDetails {
  public NotAuthenticatedProblemDetails() {
    super("Authentication Error","You are not authenticated","NotAuthenticatedException");
  }
}
