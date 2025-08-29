package com.jorge.practico2libros;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.jorge.practico2libros.busqueda.BusquedaViewModel;
import com.jorge.practico2libros.detalle.DetalleActivity;
import com.jorge.practico2libros.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private BusquedaViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // ✅ Usamos ViewBinding en vez de setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // ✅ Mantener tu configuración de Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // ✅ Inicializamos el ViewModel
        viewModel = new ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())
        ).get(BusquedaViewModel.class);



        // ✅ Observamos resultados exitosos
        viewModel.getLibroEncontrado().observe(this, libro -> {
            Intent intent = new Intent(this, DetalleActivity.class);
            intent.putExtra("libro", libro);
            startActivity(intent);
        });

        // ✅ Observamos errores
        viewModel.getError().observe(this, error -> {
            binding.tvMensaje.setText(error);
        });

        // ✅ Listener para el botón buscar
        binding.btnBuscar.setOnClickListener(v -> {
            String titulo = binding.etTitulo.getText().toString().trim();
            viewModel.buscarLibro(titulo);
        });
    }
}
