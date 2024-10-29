package com.ama.agencybooks.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="books")
@Data
public class Book {

    @Id
    @GeneratedValue()
    @Column(name="id")
    private Long id;

    @Column(unique=true)
    @NotNull
    private String title;

    @Column
    @NotNull
    private String author;

    @Column
    @NotNull
    private SecurityLevel classification;

}