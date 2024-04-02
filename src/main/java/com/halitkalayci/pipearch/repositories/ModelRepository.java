package com.halitkalayci.pipearch.repositories;

import com.halitkalayci.pipearch.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>Defines the repository interface for handling CRUD
 * operations on a specific entity type <b>`Model`</b>,
 * leveraging Spring Data JPA's automatic query generation.</p>
 */
public interface ModelRepository extends JpaRepository<Model, Long> { }
