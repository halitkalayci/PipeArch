package com.halitkalayci.pipearch.repositories;

import com.halitkalayci.pipearch.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * <p>Defines the repository interface for handling CRUD
 * operations on a specific entity type <b>`Brand`</b>,
 * leveraging Spring Data JPA's automatic query generation.</p>
 */

public interface BrandRepository extends JpaRepository<Brand, Long> { }
