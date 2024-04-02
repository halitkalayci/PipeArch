package com.halitkalayci.pipearch.domain;

import com.halitkalayci.pipearch.core.domain.BaseEntity;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * <p>Represents the entity model for <b>`brands`</b> table in the database,
 * mapping its columns to class fields with JPA annotations.</p>
 */
@Table(name = "brands")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Brand extends BaseEntity<Long> {
  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "brand")
  private Set<Model> models = new HashSet<>();
}
