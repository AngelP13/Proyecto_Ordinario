package com.example.proyecto_ordinario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Opciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        Button btninventario = findViewById(R.id.inventario);
        Button btnventa = findViewById(R.id.venta);
        btninventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Opciones.this, BaseDatos.class);
                startActivity(intent);
            }

        });

        btnventa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Opciones.this, Venta.class);
                startActivity(intent);

                Button salir = findViewById(R.id.salir);
                salir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        salir();
                    }
                    private void salir() {
                        System.exit(0);}

                });

            }
        });

    }

}
