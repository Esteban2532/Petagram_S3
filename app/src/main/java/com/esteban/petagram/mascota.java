package com.esteban.petagram;

/**
 * Created by Esteban on 18/10/2017.
 */

public class mascota {

    private int foto;
    private String nombre;
    private int raiting;


    public mascota(int foto,String nombre, int raiting) {
        this.nombre = nombre;
        this.raiting = raiting;
        this.foto = foto;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }
}
