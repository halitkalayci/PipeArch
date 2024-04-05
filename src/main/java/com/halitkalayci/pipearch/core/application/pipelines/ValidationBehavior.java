package com.halitkalayci.pipearch.core.application.pipelines;

import an.awesome.pipelinr.Command;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * Represents a middleware behavior in a command handling pipeline that
 * performs validation on command objects before they are processed by their
 * respective handlers. This behavior ensures that only valid commands are
 * executed, improving the reliability and integrity of the application.
 * <p>
 * This behavior uses the {@link Validator} to perform
 * validation. It throws a {@link RuntimeException} if validation errors are
 * found, preventing the command from being processed further in the pipeline.
 * </p>
 *
 * @see Validator the Jakarta validation mechanism used for validating commands.
 */
@Component
public class ValidationBehavior implements Command.Middleware {

  private final Validator validator;

  public ValidationBehavior(Validator validator) {
    this.validator = validator;
  }

  @Override
  public <R, C extends Command<R>> R invoke(C command, Next<R> next) {
    Set<ConstraintViolation<C>> errors = validator.validate(command);

    if (!errors.isEmpty()) {
      // TODO: Refactor with custom global exception type.
      throw new RuntimeException("Doğrulama hataları: " + errors.toString());
    }

    return next.invoke();
  }
}
