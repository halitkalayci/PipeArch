package com.halitkalayci.pipearch.core.application.pipelines.authentication;

import an.awesome.pipelinr.Command;
import com.halitkalayci.pipearch.core.utils.exceptions.types.NotAuthenticatedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * A middleware behavior that integrates with Spring Security. It checks if the user is
 * authenticated before processing commands that implement the {@link AuthenticatedRequest}
 * interface. If the user is not authenticated, it throws an {@link NotAuthenticatedException}.
 */
@Component
public class AuthenticationBehavior implements Command.Middleware {

  @Override
  public <R, C extends Command<R>> R invoke(C command, Next<R> next) {
    if (command instanceof AuthenticatedRequest) {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      if (authentication == null || !authentication.isAuthenticated()) {
        throw new NotAuthenticatedException();
      }
    }
    return next.invoke();
  }
}