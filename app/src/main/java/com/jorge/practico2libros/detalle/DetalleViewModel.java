package com.jorge.practico2libros.detalle;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jorge.practico2libros.Libro;

public class DetalleViewModel extends ViewModel {
    private MutableLiveData<Libro> libroLiveData = new MutableLiveData<>();

    public MutableLiveData<Libro> getLibro() {
        return libroLiveData;
    }

    // Método para cargar el libro recibido
    public void setLibro(Libro libro) {
        if (libro != null) {
            libroLiveData.setValue(libro);
        }
    }
}
