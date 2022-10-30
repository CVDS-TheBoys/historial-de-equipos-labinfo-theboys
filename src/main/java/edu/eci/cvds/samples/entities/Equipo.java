package edu.eci.cvds.samples.entities;

import java.io.Serializable;

public class Equipo implements Serializable {
    private int id;
    private boolean estado;
    private Integer laboratorio_id;
    private String nombre;
    // TODO private List<Novedad> novedades;

    /*public Equipo(int id, boolean estado, Integer laboratorio_id, String nombre, List<Novedad> novedades) {
        this.id = id;
        this.estado = estado;
        this.laboratorio_id = laboratorio_id;
        this.nombre = nombre;
        this.novedades = novedades;
    }*/

    public Equipo(int id, boolean estado, String nombre) {
        this.id = id;
        this.estado = estado;
        this.laboratorio_id = -1;
        this.nombre = nombre;
    }

    public Equipo(int id, boolean estado, Integer laboratorio_id, String nombre) {
        this.id = id;
        this.estado = estado;
        this.laboratorio_id = laboratorio_id;
        this.nombre = nombre;
    }

    public Equipo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Integer getLaboratorio_id() {
        return laboratorio_id;
    }

    public void setLaboratorio_id(Integer laboratorio_id) {
        this.laboratorio_id = laboratorio_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*public List<Novedad> getNovedades() {
        return novedades;
    }

    public void setNovedades(List<Novedad> novedades) {
        this.novedades = novedades;
    }*/

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", estado=" + estado +
                ", laboratorio_id=" + laboratorio_id +
                ", nombre='" + nombre + '\'' +
                //", novedades=" + novedades +
                '}';
    }
}
