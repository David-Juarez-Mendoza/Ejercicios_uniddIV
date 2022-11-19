package com.example.appfarmaciab;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.appfarmaciab.ventanas.Base;
import com.example.appfarmaciab.ventanas.GeneradorQR;
import com.example.appfarmaciab.ventanas.Publicidad;
import com.example.appfarmaciab.ventanas.Ubicacion;
import com.google.android.material.navigation.NavigationView;

public class Menus extends  AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_menus);
        setContentView(R.layout.activity_menus);
        //Buscar
        toolbar=findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        //Mostrar
        actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.Open,R.string.Close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        //Establecer el evento on click
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
       //cerrar el menu al darle clic
        drawerLayout.closeDrawer(GravityCompat.START);
        //Seleccionar una opcion del menu
        switch (item.getItemId()){
            case R.id.item1:
              //ir a la actividad
                startActivity(new Intent(Menus.this, Base.class));
                break;
            case R.id.item2:
                startActivity(new Intent(Menus.this, GeneradorQR.class));
                break;
            case R.id.item3:
                startActivity(new Intent(Menus.this, Ubicacion.class));
                break;
            case R.id.item4:
                startActivity(new Intent(Menus.this, Publicidad.class));
                break;
        }

        return false;
    }

}