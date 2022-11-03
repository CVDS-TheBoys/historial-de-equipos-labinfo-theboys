package edu.eci.cvds.samples.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ariza
 */
public class Elemento {

    private int id;
    private String nombre;
    private String tipo;
    private boolean funcional;
    private Integer equipo_id;
    private List<Novedad> novedades;

    public Elemento(int id, String nombre, String tipo, boolean funcional) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.funcional = funcional;
        this.equipo_id = null;
        this.novedades = null;
    }

    public Elemento(int id, String nombre, String tipo, boolean funcional, Integer equipo_id) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.funcional = funcional;
        this.equipo_id = equipo_id;
        this.novedades = new ArrayList<>();
    }

    public Elemento(int id, String nombre, String tipo, boolean funcional, Integer equipo_id, List<Novedad> novedades) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.funcional = funcional;
        this.equipo_id = equipo_id;
        this.novedades = novedades;
    }

    public Elemento() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isFuncional() {
        return funcional;
    }

    public void setFuncional(boolean funcional) {
        this.funcional = funcional;
    }

    public Integer getEquipo_id() {
        return equipo_id;
    }

    public void setEquipo_id(Integer equipo_id) {
        this.equipo_id = equipo_id;
    }

    public List<Novedad> getNovedades() {
        return novedades;
    }

    public void setNovedades(List<Novedad> novedades) {
        this.novedades = novedades;
    }

    @Override
    public String toString() {
        return "Elemento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", funcional=" + funcional +
                ", equipo_id=" + equipo_id +
                ", novedades=" + novedades +
                '}';
    }
}
