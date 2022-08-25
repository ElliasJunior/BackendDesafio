package com.elias.UsersDTO;

import com.elias.model.Users;
import lombok.Data;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.io.Serializable;


public class UsersDto implements Serializable {

    private Long id;

    private String name;

    private String senha;

    private String email ;

    private String perfil;

    private String validado;

    public UsersDto() {
    }

    public UsersDto(Users obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.senha = obj.getSenha();
        this.email = obj.getEmail();
        this.perfil = obj.getPerfil();
        this.validado = obj.getValidado();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getValidado() {
        return validado;
    }

    public void setValidado(String validado) {
        this.validado = validado;
    }
}
