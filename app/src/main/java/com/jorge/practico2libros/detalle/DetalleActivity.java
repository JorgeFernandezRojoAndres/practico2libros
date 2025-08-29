package com.jorge.practico2libros.detalle;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.jorge.practico2libros.Libro;
import com.jorge.practico2libros.R;

public class DetalleActivity extends AppCompatActivity {

    private TextView tvCodigo, tvTitulo, tvAutor, tvGenero, tvAnio, tvDescripcion;
    private ImageView imgLibro;
    private DetalleViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        // ✅ Referencias a las vistas
        imgLibro = findViewById(R.id.imgLibro);
        tvCodigo = findViewById(R.id.tvCodigo);
        tvTitulo = findViewById(R.id.tvTitulo);
        tvAutor = findViewById(R.id.tvAutor);
        tvGenero = findViewById(R.id.tvGenero);
        tvAnio = findViewById(R.id.tvAnio);
        tvDescripcion = findViewById(R.id.tvDescripcion);

        // ✅ Inicializar ViewModel
        viewModel = new ViewModelProvider(this).get(DetalleViewModel.class);

        // ✅ Recuperar el libro pasado desde MainActivity
        Libro libro = (Libro) getIntent().getSerializableExtra("libro");
        viewModel.setLibro(libro);

        // ✅ Observar los datos del ViewModel
        viewModel.getLibro().observe(this, libroRecibido -> {
            if (libroRecibido != null) {
                tvCodigo.setText("Código: " + libroRecibido.getCodigo());
                tvTitulo.setText("Libro: " + libroRecibido.getTitulo());
                tvAutor.setText("de: " + libroRecibido.getAutor());
                tvGenero.setText("Género: " + libroRecibido.getGenero());
                tvAnio.setText("Año: " + libroRecibido.getAnio());
                tvDescripcion.setText(libroRecibido.getDescripcion());

                // 👇 Aquí cargamos la imagen real del libro
                if (libroRecibido.getImagenResId() != 0) {
                    imgLibro.setImageResource(libroRecibido.getImagenResId());
                }
            } else {
                tvTitulo.setText("❌ No se recibió ningún libro");
            }
        });
        // ✅ Listener para el botón volver
        findViewById(R.id.btnVolver).setOnClickListener(v -> {
            finish();
        });
    }
}
