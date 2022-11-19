package com.example.appfarmaciab.ventanas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.appfarmaciab.MainActivity;
import com.example.appfarmaciab.R;


public class Publicidad extends AppCompatActivity {
    ImageView img;
    Button btn;

    Uri uriImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicidad);
        img = findViewById(R.id.imagen);
        btn = findViewById(R.id.btnEnviar);
//titulo de la ventana
        this.setTitle("Publicidad");
        //Metodo para la flecha de regreso
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentWA = new Intent(Intent.ACTION_SEND);
                intentWA.setType("image/*");
                intentWA.setPackage("com.whatsapp");

                if (uriImg != null) {
                    intentWA.putExtra(Intent.EXTRA_STREAM, uriImg);

                    try {
                        startActivity(intentWA);
                    } catch (Exception e) {
                        Toast.makeText(Publicidad.this, "Error al enviar\n" + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Publicidad.this, "No se seleccionó una imagen\n", Toast.LENGTH_LONG).show();
                }
            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGaleria = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                try {
                    startActivityForResult(intentGaleria, 1);
                } catch (Exception e) {
                    Toast.makeText(Publicidad.this, "Error al abrir galería\n" + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            uriImg = data.getData();
            img.setImageURI(uriImg);
}
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;}
}