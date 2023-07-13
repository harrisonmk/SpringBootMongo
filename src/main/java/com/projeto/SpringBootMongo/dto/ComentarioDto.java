package com.projeto.SpringBootMongo.dto;

import java.io.Serializable;
import java.util.Date;

public class ComentarioDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String texto;
    private Date date;
    private AutorDto autor;

    
    
    
    public ComentarioDto(String texto, Date date, AutorDto autor) {
        this.texto = texto;
        this.date = date;
        this.autor = autor;
    }

    public ComentarioDto() {
    }

    
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AutorDto getAutor() {
        return autor;
    }

    public void setAutor(AutorDto autor) {
        this.autor = autor;
    }

    
    
    
    
}
