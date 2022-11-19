package com.example.appfarmaciab.ventanas;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.example.appfarmaciab.R;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QR extends AppCompatActivity {
    ImageView ivCodigoQE;
    EditText etDatos;
    Button btnGenerar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        ivCodigoQE=findViewById(R.id.ivCodigob);
        etDatos = findViewById(R.id.etDatos);
        btnGenerar = findViewById(R.id.btnGenerar);
    }

    public void generar (View view){
        try{
            /*Dtaos para manejar
            *Telefono es: tel:
            * sms es: numero: mensaje
            * mail: mailto
            * */

            BarcodeEncoder barcodeEncoder= new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap("mail:"+etDatos.getText().toString(), BarcodeFormat.QR_CODE,750,750);

            ivCodigoQE.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}