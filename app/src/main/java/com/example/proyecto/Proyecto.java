package com.example.proyecto;

public class Proyecto {
    private String nombre;
    private String solera;
    private String muros;
    private String totalSuperficie;
    private String mediacanas;

    public Proyecto(String nombre, String solera, String muros, String totalSuperficie, String mediacanas) {
        this.nombre = nombre;
        this.solera = solera;
        this.muros = muros;
        this.totalSuperficie = totalSuperficie;
        this.mediacanas = mediacanas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSolera() {
        return solera;
    }

    public String getMuros() {
        return muros;
    }

    public String getTotalSuperficie() {
        return totalSuperficie;
    }

    public String getMediacanas() {
        return mediacanas;
    }
}
