package com.projeto.SpringBootMongo.dto;

import com.projeto.SpringBootMongo.modelo.Usuario;
import java.io.Serializable;

public class UsuarioDto implements Serializable  {
    
    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;
    private String email;

    
    
    public UsuarioDto(Usuario usuario) {

        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();

    }

    
    public UsuarioDto() {
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    

}
