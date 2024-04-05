package com.halitkalayci.pipearch.core.configuration;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Pipelinr;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configures the Pipelinr command and notification pipeline for the application.
 *
 * <p>
 * This configuration class sets up the Pipelinr pipeline, which is used for handling
 * commands and notifications within the application. It leverages Spring's dependency injection
 * to automatically discover and register all command handlers, notification handlers, and
 * middleware that are available in the application context.
 * </p>
 * The pipeline is configured to support command and notification processing, enabling a clean,
 * decoupled architecture that separates the concerns of command handling, notification handling,
 * and cross-cutting concerns handled by middleware.
 *
 * @see Command.Handler for how commands are handled within the pipeline.
 * @see Notification.Handler for how notifications are dispatched and handled.
 * @see Command.Middleware for how middleware can intercept and process commands and notifications.
 */
@Configuration
public class PipelineConfiguration {
  @Bean
  Pipeline pipeline(ObjectProvider<Command.Handler> commandHandlers,
                    ObjectProvider<Notification.Handler> notificationHandlers,
                    ObjectProvider<Command.Middleware> middlewares) {
    return new Pipelinr()
            .with(commandHandlers::stream)
            .with(notificationHandlers::stream)
            .with(middlewares::orderedStream);
  }
}
