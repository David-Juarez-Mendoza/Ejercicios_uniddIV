package com.example.appfarmaciab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appfarmaciab.ventanas.Base;
import com.example.appfarmaciab.ventanas.DBHelper;
import com.example.appfarmaciab.ventanas.GeneradorQR;
import com.example.appfarmaciab.ventanas.LoginActivity;
import com.example.appfarmaciab.ventanas.Publicidad;
import com.example.appfarmaciab.ventanas.Ubicacion;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    EditText username, password,repassword;
    Button btnSingUp,btnSignIn;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);

        btnSingUp = (Button) findViewById(R.id.btnSingUp);
        btnSignIn=(Button) findViewById(R.id.btnSignIn);

        myDB = new DBHelper(this);

        btnSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Llenar todo el archivo", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    if (pass.equals(repass))
                    {
                        Boolean usercheckResult = myDB.checkusername(user);
                        if (usercheckResult == false)
                        {
                            Boolean regResult = myDB.insertData(user,pass);
                            if(regResult == true){
                                Toast.makeText(MainActivity.this,"Registro exitoso", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getBaseContext(),LoginActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(MainActivity.this,"Registro fallido", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"El usuario ya existe.\n Por favor registrarse.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    else
                    {
                        Toast.makeText(MainActivity.this, "La contraseña no coincide", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });


    }


}