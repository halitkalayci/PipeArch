package com.halitkalayci.pipearch.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Table(name="models")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Model {
    @Column(name="name")
    private String name;

    @ManyToOne()
    @JoinColumn(name="brand_id")
    private Brand brand;
}
