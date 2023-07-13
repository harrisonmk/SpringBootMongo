package com.projeto.SpringBootMongo.dto;

import com.projeto.SpringBootMongo.modelo.Usuario;
import java.io.Serializable;

public class AutorDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;

    
    
    public AutorDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
    }

    public AutorDto() {
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
    
    
    
    

}
