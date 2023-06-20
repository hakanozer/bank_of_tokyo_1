package com.works.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;

    @NotNull
    @NotEmpty
    @Length(min = 4, max = 250)
    private String email;

    @NotNull
    @NotEmpty
    private String password;

    private String remember;

}
