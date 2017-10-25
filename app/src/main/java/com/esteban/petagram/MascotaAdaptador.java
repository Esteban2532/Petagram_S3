package com.esteban.petagram;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Esteban on 19/10/2017.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<mascota> mascotas;
    Activity activity;


    public MascotaAdaptador(ArrayList<mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
         return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final mascota mascota = mascotas.get(position);


        mascotaViewHolder.imgMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvnombreMascota.setText(mascota.getNombre());
        mascotaViewHolder.tvcontadorMascota.setText(Integer.toString(mascota.getRaiting()));


        mascotaViewHolder.btRaiting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int contador = mascota.getRaiting()+1;
                mascota.setRaiting(contador);
                mascotaViewHolder.tvcontadorMascota.setText(Integer.toString(mascota.getRaiting()));
            }
        });
        }



    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgMascota;
        private TextView  tvnombreMascota;
        private TextView  tvcontadorMascota;
        private ImageView btRaiting;


        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgMascota = (ImageView)itemView.findViewById(R.id.imgMascota);
            tvnombreMascota = (TextView)itemView.findViewById(R.id.tvnombreMascota);
            tvcontadorMascota = (TextView)itemView.findViewById(R.id.tvcontadorMascota);
            btRaiting = (ImageView)itemView.findViewById(R.id.btRaiting);
        }
    }

}
