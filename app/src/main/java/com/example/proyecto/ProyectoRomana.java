package com.example.proyecto;

public class ProyectoRomana {
    private String nombre;
    private String solera;
    private String muros;
    private String murosYSolera;
    private String soleraEscalera;
    private String murosEscalera;
    private String perimetroEscalera;
    private String escaleraTotal;
    private String totalSuperficie;
    private String mediacanas;

    // Constructor
    public ProyectoRomana(String nombre, String solera, String muros, String murosYSolera, String soleraEscalera,
                          String murosEscalera, String perimetroEscalera, String escaleraTotal, String totalSuperficie,
                          String mediacanas) {
        this.nombre = nombre;
        this.solera = solera;
        this.muros = muros;
        this.murosYSolera = murosYSolera;
        this.soleraEscalera = soleraEscalera;
        this.murosEscalera = murosEscalera;
        this.perimetroEscalera = perimetroEscalera;
        this.escaleraTotal = escaleraTotal;
        this.totalSuperficie = totalSuperficie;
        this.mediacanas = mediacanas;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getSolera() {
        return solera;
    }

    public String getMuros() {
        return muros;
    }

    public String getMurosYSolera() {
        return murosYSolera;
    }

    public String getSoleraEscalera() {
        return soleraEscalera;
    }

    public String getMurosEscalera() {
        return murosEscalera;
    }

    public String getPerimetroEscalera() {
        return perimetroEscalera;
    }

    public String getEscaleraTotal() {
        return escaleraTotal;
    }

    public String getTotalSuperficie() {
        return totalSuperficie;
    }

    public String getMediacanas() {
        return mediacanas;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSolera(String solera) {
        this.solera = solera;
    }

    public void setMuros(String muros) {
        this.muros = muros;
    }

    public void setMurosYSolera(String murosYSolera) {
        this.murosYSolera = murosYSolera;
    }

    public void setSoleraEscalera(String soleraEscalera) {
        this.soleraEscalera = soleraEscalera;
    }

    public void setMurosEscalera(String murosEscalera) {
        this.murosEscalera = murosEscalera;
    }

    public void setPerimetroEscalera(String perimetroEscalera) {
        this.perimetroEscalera = perimetroEscalera;
    }

    public void setEscaleraTotal(String escaleraTotal) {
        this.escaleraTotal = escaleraTotal;
    }

    public void setTotalSuperficie(String totalSuperficie) {
        this.totalSuperficie = totalSuperficie;
    }

    public void setMediacanas(String mediacanas) {
        this.mediacanas = mediacanas;
    }
}
