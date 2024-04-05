package com.halitkalayci.pipearch.core.application.pipelines.authentication;

import an.awesome.pipelinr.Command;
import com.halitkalayci.pipearch.core.utils.exceptions.types.NotAuthenticatedException;
import com.halitkalayci.pipearch.core.utils.exceptions.types.NotAuthorizedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

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

      if(command instanceof AuthorizedRequest)
      {
        List<String> requiredRoles = ((AuthorizedRequest) command).getRequiredRoles();

        boolean hasAnyMatch = authentication
                .getAuthorities()
                .stream()
                .anyMatch(i->requiredRoles
                        .stream()
                        .anyMatch(x-> x.equalsIgnoreCase(i.getAuthority())));

        if(!hasAnyMatch)
          throw new NotAuthorizedException();
      }
    }
    return next.invoke();
  }
}