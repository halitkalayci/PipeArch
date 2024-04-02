package com.halitkalayci.pipearch.application.features.brands.commands.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * <p>Defines a Data Transfer Object (DTO) class used to encapsulate data attributes
 * and transfer them between different
 * layers of the application, promoting loose coupling and encapsulation.</p>
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatedBrandResponse {
  private Long id;
  private String name;
}
