package com.halitkalayci.pipearch.core.domain.concretes;


import com.halitkalayci.pipearch.core.domain.abstracts.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="operation_claims")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OperationClaim extends BaseEntity<Integer> implements GrantedAuthority {
  @Column(name="name")
  private String name;

  @ManyToMany(mappedBy = "authorities")
  private Set<User> users = new HashSet<>();

  @Override
  public String getAuthority() {
    return name;
  }
}
