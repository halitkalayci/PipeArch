package com.halitkalayci.pipearch.application.features.brands.commands.create;

import an.awesome.pipelinr.Command;
import com.halitkalayci.pipearch.application.features.brands.mappers.BrandMapper;
import com.halitkalayci.pipearch.domain.Brand;
import com.halitkalayci.pipearch.repositories.BrandRepository;
import lombok.*;
import org.springframework.stereotype.Component;

/**
 * <p>Represents a command in a CQRS and pipeline-based system, encapsulating all the
 * necessary information for an action to be performed <b>(Create Brand)</b>,
 * typically resulting in a state change within the system.</p>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandCommand implements Command<CreatedBrandResponse> {
  private String name;

  /**
   * <p>Defines the handler responsible for processing the specific command <b>(Create Brand)</b>,
   * implementing the logic to execute
   * the desired action on the system's state,
   * and adhering to the principles of CQRS and pipeline architecture.</p>
   */
  @RequiredArgsConstructor
  @Component
  public static class CreateBrandCommandHandler
          implements Command.Handler<CreateBrandCommand, CreatedBrandResponse> {
    private final BrandRepository brandRepository;

    @Override
    public CreatedBrandResponse handle(CreateBrandCommand createBrandCommand) {
      Brand brand = BrandMapper.INSTANCE.brandFromCreateBrandCommand(createBrandCommand);
      brand = brandRepository.save(brand);
      CreatedBrandResponse response = BrandMapper.INSTANCE.createdBrandResponseFromBrand(brand);
      return response;
    }
  }
}
