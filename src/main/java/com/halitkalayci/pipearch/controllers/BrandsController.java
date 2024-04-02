package com.halitkalayci.pipearch.controllers;

import an.awesome.pipelinr.Pipelinr;
import com.halitkalayci.pipearch.application.features.brands.commands.create.CreateBrandCommand;
import com.halitkalayci.pipearch.application.features.brands.commands.create.CreatedBrandResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

/***
 * <p>
 *   Exposes a set of RESTful endpoints, handling HTTP requests
 *   and responses for specific resource <b>(Brand)</b>,
 *   and orchestrating interactions between the client and the application's services or data.
 * </p>
 */
@RestController
@RequestMapping("/api/v1/brands")
public class BrandsController {
  @PostMapping
  public ResponseEntity<CreatedBrandResponse> createBrand(@RequestBody CreateBrandCommand command) {
    CreatedBrandResponse response = new Pipelinr().send(command);
    return ResponseEntity.ok().body(response);
  }
}
