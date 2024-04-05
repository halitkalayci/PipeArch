package com.halitkalayci.pipearch.application.features.brands.mappers;

import com.halitkalayci.pipearch.application.features.brands.commands.create.CreateBrandCommand;
import com.halitkalayci.pipearch.application.features.brands.commands.create.CreatedBrandResponse;
import com.halitkalayci.pipearch.domain.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
/**
 * Defines mapping operations between <b>Brand</b> domain objects and their corresponding
 * Data Transfer Objects (DTOs) for brand creation commands and responses.
 * <p>
 * This interface uses MapStruct, a code generator that greatly simplifies the implementation
 * of mappings between Java bean types based on a convention over configuration approach.
 * </p>
 * Utilizing this mapper facilitates maintaining clean architecture principles by separating
 * the domain logic from the web layer, and helps in automating the mapping process, reducing
 * potential human errors and the need for manual conversion logic.
 */

@Mapper
public interface BrandMapper {
  BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

  Brand brandFromCreateBrandCommand(CreateBrandCommand command);

  CreatedBrandResponse createdBrandResponseFromBrand(Brand brand);
}
