package com.halitkalayci.pipearch.controllers;

import an.awesome.pipelinr.Pipeline;
import com.halitkalayci.pipearch.application.features.brands.commands.create.CreateBrandCommand;
import com.halitkalayci.pipearch.application.features.brands.commands.create.CreatedBrandResponse;
import com.halitkalayci.pipearch.core.web.BaseController;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * <p>
 *   Exposes a set of RESTful endpoints, handling HTTP requests
 *   and responses for specific resource <b>(Brand)</b>,
 *   and orchestrating interactions between the client and the application's services or data.
 * </p>
 */
@RestController
@RequestMapping("/api/v1/brands")
public class BrandsController extends BaseController {

  public BrandsController(Pipeline pipeline) {
    super(pipeline);
  }

  @PostMapping
  public ResponseEntity<?> createBrand(@RequestBody CreateBrandCommand command) {
    CreatedBrandResponse response = command.execute(pipeline);

    URI location = uriForCreatedResource("/{id}", response.getId());

    return ResponseEntity.created(location).body(response);
  }
}
