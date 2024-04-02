package com.halitkalayci.pipearch;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Pipelinr;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/***
 * <p>Defines the main application class that launches
 * the Spring Boot application using @SpringBootApplication annotation.</p>
 */
@SpringBootApplication
public class PipeArchApplication {

  public static void main(String[] args) {
    SpringApplication.run(PipeArchApplication.class, args);
  }


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
