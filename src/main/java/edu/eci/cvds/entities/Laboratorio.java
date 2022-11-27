package edu.eci.cvds.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Laboratorio {
    private int id;
    private String nombre;
    private Integer cantidad_equipos;
    private boolean estado;
    private Date fecha_creacion;
    private Date fecha_cierre;
    private List<Equipo> equipos;

    public Laboratorio(int id, String nombre, Integer cantidad_equipos, boolean estado, Date fecha_creacion,
            Date fecha_cierre,
            List<Equipo> equipos) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad_equipos = cantidad_equipos;
        this.estado = estado;
        this.fecha_creacion = fecha_creacion;
        this.fecha_cierre = fecha_cierre;
        this.equipos = equipos;
    }

    public Laboratorio(int id, String nombre, Integer cantidad_equipos, boolean estado, Date fecha_creacion) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad_equipos = cantidad_equipos;
        this.estado = estado;
        this.fecha_creacion = fecha_creacion;
        this.fecha_cierre = null;
        this.equipos = new ArrayList<>();
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad_equipos() {
        return cantidad_equipos;
    }

    public void setCantidad_equipos(int cantidad_equipos) {
        this.cantidad_equipos = cantidad_equipos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(Date fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

    @Override
    public String toString() {
        return "Laboratorio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidad_equipos=" + cantidad_equipos +
                ", estado=" + estado +
                ", fecha_creacion=" + fecha_creacion +
                ", fecha_cierre=" + fecha_cierre +
                '}';
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }
}
