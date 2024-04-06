package com.halitkalayci.pipearch.core.application.pipelines.auth;

import java.util.List;

public interface AuthorizedRequest extends AuthenticatedRequest {
  List<String> getRequiredRoles();
}
