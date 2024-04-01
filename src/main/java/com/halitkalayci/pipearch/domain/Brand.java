package com.halitkalayci.pipearch.domain;

import com.halitkalayci.pipearch.core.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Table(name="brands")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Brand extends BaseEntity<Long> {
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "brand")
    private Set<Model> models = new HashSet<>();
}
