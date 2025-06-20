package com.sibirajen.Blogging.API.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;

@Getter
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false)
    private Long id;
}
