package com.example.proyecto_ordinario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnaceptar = findViewById(R.id.aceptar);
        btnaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnaceptar("¡Tu registro fue completado con exito!");
                // Cambiar a la siguiente pantalla
                Intent intent = new Intent(MainActivity.this, Opciones.class);
                startActivity(intent);
            }
        });
    }

    private void btnaceptar(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }


}