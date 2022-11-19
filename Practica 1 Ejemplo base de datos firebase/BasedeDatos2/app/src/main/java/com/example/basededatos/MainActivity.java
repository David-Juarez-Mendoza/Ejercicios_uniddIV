package com.example.basededatos;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText nombre, uso_med, codigo_med, precio_med;
    private DatabaseReference db_prod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (EditText) findViewById(R.id.nombre_med);
        uso_med = (EditText) findViewById(R.id.uso_med);
        codigo_med = (EditText) findViewById(R.id.codigo_med);
        precio_med = (EditText) findViewById(R.id.precio_med);

        db_prod = FirebaseDatabase.getInstance().getReference();
    }
    public void Alta_prod (View view){
        String nombreS = nombre.getText().toString();
        String usoS = uso_med.getText().toString();
        double codigo_unitario = Double.parseDouble(codigo_med.getText().toString());
        long precio_prod = Long.parseLong((precio_med.getText().toString()));
        try {
            Map<String, Object> datosProd = new HashMap<>();
            datosProd.put("nombre",nombreS);
            datosProd.put("uso",usoS);
            datosProd.put("codigo_unitario",codigo_unitario);
            datosProd.put("precio_prod",precio_prod);
            db_prod.child("Productos").child(nombreS).setValue(datosProd);
            Toast.makeText(this,"Registro Exitoso",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this,"Hubo un problema",Toast.LENGTH_SHORT).show();
        }
    }
    public void Baja_prod (View view){
        String nombreS = nombre.getText().toString();
        try {
            DatabaseReference drProducto = FirebaseDatabase.getInstance().getReference("Productos").child(nombreS);
            drProducto.removeValue();
            Toast.makeText(this,"Baja exitosa", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this,"Hubo un problema",Toast.LENGTH_SHORT).show();
        }
    }
    public void Modificar_prod (View view){
        String nombreS = nombre.getText().toString();
        String usoS = uso_med.getText().toString();
        double codigo_unitario = Double.parseDouble(codigo_med.getText().toString());
        long precio_prod = Long.parseLong((precio_med.getText().toString()));
        try {
            Map<String, Object> datosProdMod = new HashMap<>();
            datosProdMod.put("nombre",nombreS);
            datosProdMod.put("uso",usoS);
            datosProdMod.put("codigo_unitario",codigo_unitario);
            datosProdMod.put("precio_prod",precio_prod);
            DatabaseReference mdProducto = FirebaseDatabase.getInstance().getReference("Productos").child(nombreS);
            mdProducto.updateChildren(datosProdMod);
            Toast.makeText(this, "Cambio Exitoso", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, "Hubo un problema", Toast.LENGTH_SHORT).show();
        }
    }

}