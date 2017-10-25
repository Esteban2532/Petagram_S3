package com.esteban.petagram;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;


public class ListadoMascotas extends AppCompatActivity  {
    private RecyclerView listadoMascostas;
    ArrayList<mascota> mascotas;


    int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_mascotas);

        Toolbar myActionBar = (Toolbar)findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);

        //Esta instruccion me ayuda a montar el boton de hacia atras
        ActionBar ab = getSupportActionBar ();
        ab . setDisplayHomeAsUpEnabled ( true );

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones2, menu);
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
        }
        return super.onOptionsItemSelected(item);
    }

    public void inicializarListadeMascotas(){


        mascotas = new ArrayList<mascota>();

        mascotas.add(new mascota(R.drawable.perro2 ,"MariaCharito",contador));
        mascotas.add(new mascota(R.drawable.perro4 ,"Lupe",contador));
        mascotas.add(new mascota(R.drawable.perro5, "Bettoween",contador));
        mascotas.add(new mascota(R.drawable.perro1 ,"Firulais",contador));
        mascotas.add(new mascota(R.drawable.perro3, "Zeus",contador));


    }



}
