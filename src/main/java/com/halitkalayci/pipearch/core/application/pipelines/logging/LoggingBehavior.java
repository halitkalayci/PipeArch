package com.halitkalayci.pipearch.core.application.pipelines.logging;

import an.awesome.pipelinr.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingBehavior implements Command.Middleware {

  private static final Logger logger = LoggerFactory.getLogger(LoggingBehavior.class);

  @Override
  public <R, C extends Command<R>> R invoke(C command, Next<R> next) {
    try {
      logger.info("Processing command: {} with parameters: {}", command.getClass().getName(), command.toString());

      long startTime = System.currentTimeMillis();
      R result = next.invoke();
      long endTime = System.currentTimeMillis();

      logger.info("Completed command: {} in {} ms", command.getClass().getName(), endTime - startTime);

      return result;
    } catch (RuntimeException e) {
      logger.error("Error processing command: {} with error: {} with parameters: {}", command.getClass().getName(), e.getMessage(), command.toString());
      throw e;
    }
  }
}