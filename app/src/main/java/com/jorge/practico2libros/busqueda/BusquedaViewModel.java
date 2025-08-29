package com.jorge.practico2libros.busqueda;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jorge.practico2libros.Libro;
import com.jorge.practico2libros.repository.LibroRepositorio;

public class BusquedaViewModel extends ViewModel {

    private final MutableLiveData<Libro> libroEncontrado = new MutableLiveData<>();
    private final MutableLiveData<String> error = new MutableLiveData<>();

    private final LibroRepositorio repositorio = new LibroRepositorio();

    public MutableLiveData<Libro> getLibroEncontrado() {
        return libroEncontrado;
    }

    public MutableLiveData<String> getError() {
        return error;
    }

    public void buscarLibro(String titulo) {
        Libro libro = repositorio.buscarPorTitulo(titulo);
        if (libro != null) {
            libroEncontrado.setValue(libro);
        } else {
            error.setValue("❌ Libro no encontrado");
        }
    }
}
