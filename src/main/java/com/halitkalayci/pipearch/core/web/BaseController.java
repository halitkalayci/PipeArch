package com.halitkalayci.pipearch.core.web;

import an.awesome.pipelinr.Pipeline;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
public abstract class BaseController {
  protected final Pipeline pipeline;

  protected URI uriForCreatedResource(String path, Object... buildParams){
    return ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path(path)
            .buildAndExpand(buildParams)
            .toUri();
  }
}
