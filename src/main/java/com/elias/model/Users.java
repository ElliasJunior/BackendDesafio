package com.elias.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class Users {

    @Id
    @JsonProperty("_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (nullable = false, length = 200)
    private String name;

    @Column (nullable = false, length = 80)
    private String senha;

    @Column (nullable = false, length = 100)
    private String email ;

    @Column (length = 20)
    private String perfil;

    @Column (length = 20)
    private String validado;
}
