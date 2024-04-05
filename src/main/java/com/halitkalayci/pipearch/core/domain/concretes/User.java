package com.halitkalayci.pipearch.core.domain.concretes;

import com.halitkalayci.pipearch.core.domain.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity<Integer> implements UserDetails {
  @Column(name="email")
  private String email;

  @Column(name="password")
  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name="user_operation_claims",
          joinColumns = @JoinColumn(name="user_id"),
          inverseJoinColumns = @JoinColumn(name="operation_claim_id"))
  private Set<OperationClaim> authorities = new HashSet<>();

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
