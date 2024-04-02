package com.halitkalayci.pipearch.application.features.brands.mappers;

import com.halitkalayci.pipearch.application.features.brands.commands.create.CreateBrandCommand;
import com.halitkalayci.pipearch.application.features.brands.commands.create.CreatedBrandResponse;
import com.halitkalayci.pipearch.domain.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandMapper {
  BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

  Brand brandFromCreateBrandCommand(CreateBrandCommand command);

  CreatedBrandResponse createdBrandResponseFromBrand(Brand brand);
}
