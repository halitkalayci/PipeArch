package com.halitkalayci.pipearch.core.utils.exceptions.problemDetails.custom;

import com.halitkalayci.pipearch.core.utils.exceptions.problemDetails.ProblemDetails;



public class NotAuthorizedProblemDetails extends ProblemDetails {
  public NotAuthorizedProblemDetails() {
    super("Authorization Error","You dont have access to do this.","NotAuthorizedException");
  }
}
