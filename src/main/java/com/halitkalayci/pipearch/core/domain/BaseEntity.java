package com.halitkalayci.pipearch.core.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity<T>
{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;


    @Column(name="created_date")
    private LocalDateTime createdDate;
    @Column(name="updated_date")
    private LocalDateTime updatedDate;
    @Column(name="deleted_date")
    private LocalDateTime deletedDate;

    @PrePersist
    public void prePersist()
    {
        createdDate = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate()
    {
        updatedDate = LocalDateTime.now();
    }
    @PreRemove
    public void preRemove()
    {
        deletedDate = LocalDateTime.now();
    }
}
