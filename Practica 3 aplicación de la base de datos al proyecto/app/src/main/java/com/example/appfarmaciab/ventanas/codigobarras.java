package com.example.appfarmaciab.ventanas;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.example.appfarmaciab.R;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class codigobarras extends AppCompatActivity {

    Button btnScan;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigobarras);

        btnScan=findViewById(R.id.btnScan);
        txtResultado=findViewById(R.id.txtResultado);

        btnScan.setOnClickListener(v->
        {
            scanCode();
        });


        }

    private void scanCode() {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volunm up to flash on");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLaucher.launch(options);
    }
    ActivityResultLauncher<ScanOptions> barLaucher = registerForActivityResult(new ScanContract(), result->
    {
       if(result.getContents() !=null)
       {
           AlertDialog.Builder builder = new AlertDialog.Builder(codigobarras.this);
           builder.setTitle("Result");
           builder.setMessage(result.getContents());
           builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   dialogInterface.dismiss();
               }
           }).show();
       }
    });
}