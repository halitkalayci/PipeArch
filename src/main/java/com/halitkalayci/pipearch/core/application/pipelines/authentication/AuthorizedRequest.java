package com.halitkalayci.pipearch.core.application.pipelines.authentication;

import java.util.List;

public interface AuthorizedRequest extends AuthenticatedRequest {
  List<String> getRequiredRoles();
}
