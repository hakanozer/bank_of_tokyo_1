package com.works.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UseCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plainText;
    private String useKey;

}
