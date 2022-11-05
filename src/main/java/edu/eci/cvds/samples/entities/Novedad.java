package edu.eci.cvds.samples.entities;

import java.util.Date;

public class Novedad {
    private int id;
    private String titulo;
    private String detalle;
    private Date fecha;
    private Integer EQUIPO_id;
    private int ELEMENTO_id;

    public Novedad(int id, String titulo, String detalle, Date fecha, Integer EQUIPO_id, int ELEMENTO_id) {
        this.id = id;
        this.titulo = titulo;
        this.detalle = detalle;
        this.fecha = fecha;
        this.EQUIPO_id = EQUIPO_id;
        this.ELEMENTO_id = ELEMENTO_id;
    }

    public Novedad(int id, String titulo, String detalle, Date fecha, int ELEMENTO_id) {
        this.id = id;
        this.titulo = titulo;
        this.detalle = detalle;
        this.fecha = fecha;
        this.EQUIPO_id = null;
        this.ELEMENTO_id = ELEMENTO_id;
    }

    public Novedad() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getEQUIPO_id() {
        return EQUIPO_id;
    }

    public void setEQUIPO_id(Integer EQUIPO_id) {
        this.EQUIPO_id = EQUIPO_id;
    }

    public Integer getELEMENTO_id() {
        return ELEMENTO_id;
    }

    public void setELEMENTO_id(int ELEMENTO_id) {
        this.ELEMENTO_id = ELEMENTO_id;
    }

    @Override
    public String toString() {
        return "Novedad{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", detalle='" + detalle + '\'' +
                ", fecha=" + fecha +
                ", EQUIPO_id=" + EQUIPO_id +
                ", ELEMENTO_id=" + ELEMENTO_id +
                '}';
    }
}
