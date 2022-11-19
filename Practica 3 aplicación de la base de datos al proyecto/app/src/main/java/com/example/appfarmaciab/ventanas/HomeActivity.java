package com.example.appfarmaciab.ventanas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appfarmaciab.Menus;
import com.example.appfarmaciab.R;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    Button btnQR;
    Button btnLector1;
    Button btcarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnQR = (Button) findViewById(R.id.btnQR);
        btnLector1 =(Button) findViewById(R.id.btnLector1);
        btcarga =(Button) findViewById(R.id.btcarga);

        btnQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,QR.class);
                startActivity(intent);
            }
        });
        btnLector1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,codigobarras.class);
                startActivity(intent);
            }
        });
        btcarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,Menus.class);
                startActivity(intent);
            }
        });
    }
}