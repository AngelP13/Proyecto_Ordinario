package com.example.proyecto_ordinario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class BaseDatos extends AppCompatActivity {
    EditText producto,precio;
    Button  guardar,leerb,eliminar,update;
    TextView contenidob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_datos);
        producto=(EditText)findViewById(R.id.producto);
        precio=(EditText)findViewById(R.id.precio);
        guardar=(Button)findViewById(R.id.guardar);
        leerb=(Button)findViewById(R.id.leerb);
        eliminar=(Button)findViewById(R.id.eliminar);
        update=(Button)findViewById(R.id.update);
        contenidob=(TextView)findViewById(R.id.contenidob);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!producto.getText().toString().equals("")&&!precio.getText().toString().equals(""))
                    GuardarRegistro(producto.getText().toString(),precio.getText().toString());
                else
                    Toast.makeText(getApplicationContext(),"Debes capturar en ambos campos",Toast.LENGTH_SHORT).show();
            }
        });
        leerb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LeerRegistros();
            }
        });
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarRegistro(producto.getText().toString());
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aztualizarRegistro(producto.getText().toString(),precio.getText().toString());
            }
        });
    }

    private void aztualizarRegistro(String productos, String precios) {
        AdminSQLITEHelper admin = new AdminSQLITEHelper(this,"TiendaBD",null,1);
        SQLiteDatabase basedatos= admin.getReadableDatabase();
        ContentValues registro= new ContentValues();
        registro.put("Precio",precios);
        basedatos.update("alumnos",registro,"nombre='"+productos+"'",null);
        basedatos.close();
        producto.setText("");
        precio.setText("");
    }

    private void eliminarRegistro(String productos) {
        AdminSQLITEHelper admin = new AdminSQLITEHelper(this,"TiendaBD",null,1);
        SQLiteDatabase basedatos= admin.getReadableDatabase();
        basedatos.delete("producto","precio='"+productos+"'",null);
        basedatos.close();
        Toast.makeText(getApplicationContext(),"Registro eliminado con exito!!",Toast.LENGTH_SHORT).show();
        producto.setText("");
    }

    private void LeerRegistros() {
        AdminSQLITEHelper admin = new AdminSQLITEHelper(this,"TiendaBD",null,1);
        SQLiteDatabase basedatos= admin.getReadableDatabase();
        try{
            Cursor cursor = basedatos.rawQuery("SELECT * FROM productos",null);
            String cont="";
            while (cursor.moveToNext()){
                cont+="Producto :"+cursor.getString(1)+"       Precio:"+cursor.getString(2)+"\n";
            }
            cursor.close();
            contenidob.setText(cont);
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"ERROR:"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    private void GuardarRegistro(String productos, String precios) {
        AdminSQLITEHelper admin = new AdminSQLITEHelper(getApplicationContext(),"TiendaBD",null,1);
        SQLiteDatabase basedatos= admin.getReadableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("Producto",productos);
        registro.put("Precio",precios);
        basedatos.insert("Producto",null,registro);
        basedatos.close();
        Toast.makeText(getApplicationContext(),"Registro Insertado con exito",Toast.LENGTH_SHORT).show();
        producto.setText("");
        precio.setText("");

    }
}