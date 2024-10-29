package com.ama.agencybooks.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @GeneratedValue()
    @Column(name="id")
    private Long id;

    @Column(unique=true)
    @NotNull
    private String userName;

    @Column(unique=true)
    @NotNull
    private String fullName;

    @Column
    @NotNull
    private SecurityLevel clearance;

}
