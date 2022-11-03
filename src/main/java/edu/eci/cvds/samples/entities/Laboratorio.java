package edu.eci.cvds.samples.entities;

import java.sql.Date;

public class Laboratorio {

    private int id;
    private String nombre;
    private int cantidad_equipos;
    private boolean estado;
    private Date fecha_creacion;
    private Date fecha_cierre;

    public Laboratorio(int id, String nombre, int cantidad_equipo, boolean estado,Date fecha_creacion,Date fecha_cierre) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.fecha_creacion = fecha_creacion;
        this.fecha_cierre = fecha_cierre;
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
}
