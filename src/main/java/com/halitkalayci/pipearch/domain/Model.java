package com.halitkalayci.pipearch.domain;

import com.halitkalayci.pipearch.core.domain.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>Represents the entity model for <b>`models`</b> table in the database,
 * mapping its columns to class fields with JPA annotations.</p>
 */
@Table(name = "models")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Model extends BaseEntity<Long> {
  @Column(name = "name")
  private String name;

  @ManyToOne()
  @JoinColumn(name = "brand_id")
  private Brand brand;
}
