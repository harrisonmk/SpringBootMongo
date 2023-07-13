package com.projeto.SpringBootMongo.modelo;

import com.projeto.SpringBootMongo.dto.AutorDto;
import com.projeto.SpringBootMongo.dto.ComentarioDto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Post implements Serializable  {
    
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Date date;
    private String titulo;
    private String corpo;
    private AutorDto autor;

    private List<ComentarioDto> comentarios = new ArrayList<>();

    
    
    
    public Post(String id, Date date, String titulo, String corpo, AutorDto autor) {
        this.id = id;
        this.date = date;
        this.titulo = titulo;
        this.corpo = corpo;
        this.autor = autor;
    }

    public Post() {
    }

    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public AutorDto getAutor() {
        return autor;
    }

    public void setAutor(AutorDto autor) {
        this.autor = autor;
    }

    public List<ComentarioDto> getComentarios() {
        return comentarios;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Post other = (Post) obj;
        return Objects.equals(this.id, other.id);
    }


    
      

}
