package com.example.proyecto;

import java.util.ArrayList;
import java.util.List;

public class SharedData {
    private static SharedData instance;
    private List<Proyecto> proyectos;              // Lista para proyectos rectangulares
    private List<ProyectoRomana> proyectosRomana;  // Lista para proyectos tipo Romana

    private SharedData() {
        proyectos = new ArrayList<>();
        proyectosRomana = new ArrayList<>();
    }

    public static SharedData getInstance() {
        if (instance == null) {
            instance = new SharedData();
        }
        return instance;
    }

    // Métodos para Proyecto Rectangular
    public void addProyecto(Proyecto proyecto) {
        proyectos.add(proyecto);
    }

    public void removeProyecto(int position) {
        if (position >= 0 && position < proyectos.size()) {
            proyectos.remove(position);
        }
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    // Métodos para Proyecto Romana
    public void addProyectoRomana(ProyectoRomana proyectoRomana) {
        proyectosRomana.add(proyectoRomana);
    }

    public void removeProyectoRomana(int position) {
        if (position >= 0 && position < proyectosRomana.size()) {
            proyectosRomana.remove(position);
        }
    }

    public List<ProyectoRomana> getProyectosRomana() {
        return proyectosRomana;
    }
}
