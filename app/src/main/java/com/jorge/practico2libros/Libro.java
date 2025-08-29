package com.jorge.practico2libros;

import java.io.Serializable;

public class Libro implements Serializable {

    private String codigo;
    private String titulo;
    private String autor;
    private String genero;
    private int anio;
    private String descripcion;   // 🔹 Nuevo campo
    private int imagenResId;      // 🔹 Nuevo campo (id drawable)

    // Constructor SIN año (compatibilidad)
    public Libro(String codigo, String titulo, String autor, String genero) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anio = 0;
        this.descripcion = "";
        this.imagenResId = 0;
    }

    // Constructor CON año
    public Libro(String codigo, String titulo, String autor, String genero, int anio) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anio = anio;
        this.descripcion = "";
        this.imagenResId = 0;
    }

    // 🔹 Constructor completo (con descripción e imagen)
    public Libro(String codigo, String titulo, String autor, String genero, int anio, String descripcion, int imagenResId) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anio = anio;
        this.descripcion = descripcion;
        this.imagenResId = imagenResId;
    }

    // Getters
    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getGenero() { return genero; }
    public int getAnio() { return anio; }
    public String getDescripcion() { return descripcion; }
    public int getImagenResId() { return imagenResId; }
}
