package com.esteban.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    int contador = 1;
    ArrayList<mascota> mascotas;
    private RecyclerView listadoMascostas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myActionBar = (Toolbar)findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);

        listadoMascostas = (RecyclerView)findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listadoMascostas.setLayoutManager(llm);

        inicializarListadeMascotas();
        inicializarAdaptador();
    }

    private void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listadoMascostas.setAdapter(adaptador);

    }

    public void inicializarListadeMascotas(){


        mascotas = new ArrayList<mascota>();
        mascotas.add(new mascota(R.drawable.perro1 ,"Firulais",contador));
        mascotas.add(new mascota(R.drawable.perro2 ,"MariaCharito",contador));
        mascotas.add(new mascota(R.drawable.perro3, "Zeus",contador));
        mascotas.add(new mascota(R.drawable.perro4 ,"Lupe",contador));
        mascotas.add(new mascota(R.drawable.perro5, "Bettoween",contador));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.mAbout:
                //Intent intent = new Intent(this, ActivityAbout.class);
                //startActivity(intent);
                break;
            case R.id.mSettings:
                //Intent i = new Intent(this, ActivitySettings.class);
                //startActivity(i);
                break;
            case R.id.mRefresh:
                Intent r = new Intent(this, ListadoMascotas.class);
                startActivity(r);
                break;

        }
        return super.onOptionsItemSelected(item);
    }



}
