package com.jorge.practico2libros.repository;

import java.util.ArrayList;
import com.jorge.practico2libros.Libro;
import com.jorge.practico2libros.R; // 🔹 necesario para usar R.drawable

public class LibroRepositorio {

    private ArrayList<Libro> listaLibros;

    public LibroRepositorio() {
        listaLibros = new ArrayList<>();

        // 📚 Agregamos algunos libros con año, descripción e imagen
        listaLibros.add(new Libro(
                "1",
                "El Quijote",
                "Miguel de Cervantes",
                "Novela",
                1605,
                "Considerada la primera novela moderna. Narra las aventuras de Don Quijote y su fiel escudero Sancho Panza en una sátira de los libros de caballería.",
                R.drawable.el_quijote
        ));

        listaLibros.add(new Libro(
                "2",
                "Cien Años de Soledad",
                "Gabriel García Márquez",
                "Realismo mágico",
                1967,
                "Relata la historia de la familia Buendía en el mítico pueblo de Macondo, combinando lo real y lo fantástico. Una obra maestra de la literatura latinoamericana.",
                R.drawable.cien_anos
        ));

        listaLibros.add(new Libro(
                "3",
                "1984",
                "George Orwell",
                "Distopía",
                1949,
                "Novela distópica que describe un futuro totalitario vigilado por el Gran Hermano. Es una crítica sobre la vigilancia, la censura y la pérdida de libertades.",
                R.drawable.a1984
        ));

        listaLibros.add(new Libro(
                "4",
                "La Odisea",
                "Homero",
                "Épica",
                -800,
                "Poema épico griego que narra el regreso de Ulises (Odiseo) a Ítaca tras la Guerra de Troya. Repleto de aventuras, dioses y monstruos mitológicos.",
                R.drawable.la_odisea
        ));
    }

    // ✅ Método para devolver toda la lista
    public ArrayList<Libro> getLibros() {
        return listaLibros;
    }

    // ✅ Método para buscar un libro por título
    public Libro buscarPorTitulo(String titulo) {
        for (Libro l : listaLibros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                return l;
            }
        }
        return null; // No encontrado
    }
}
