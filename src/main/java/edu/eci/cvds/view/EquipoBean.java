package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.samples.services.ServiciosEquipo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Arrays;
import java.util.List;

/**
 * Bean para la interfaz de usuario de los equipos
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "EquiposBean")
@SessionScoped
public class EquipoBean extends BasePageBean{
    @Inject
    private ServiciosEquipo serviciosEquipo;

    private List<Equipo> listaEquipos;
    private List<Equipo> listaEquiposFiltrada;

    private Equipo equipoSeleccionado;

    private List<Equipo> equiposSeleccionados;

    /**
     * Registra un equipo
     * @param id de equipo
     * @param nombre del equipo
     */
    public void registrarEquipo(int id, String nombre) {
        Equipo equipo = new Equipo(id, true, nombre);
        try {
            serviciosEquipo.registrarEquipo(equipo);
        } catch (ExcepcionServiciosLaboratorio ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Consulta todos los equipos
     */
    public List<Equipo> consultarEquipos(){
        try{
            return serviciosEquipo.consultarEquipos();
        } catch (ExcepcionServiciosLaboratorio excepcionServiciosLaboratorio) {
            excepcionServiciosLaboratorio.printStackTrace();
            return null;
        }
    }

    /** Consulta el reporte de los equipos activos
     */
    public List<Equipo> consultarReporte() {
        try {
            return serviciosEquipo.consultarReporte();
        } catch (ExcepcionServiciosLaboratorio excepcionServiciosLaboratorio) {
            excepcionServiciosLaboratorio.printStackTrace();
            return null;
        }
    }

    public void setListaEquipos(List<Equipo> listaEquipos) {
        try {
            this.listaEquipos = serviciosEquipo.consultarEquipos();
        } catch (ExcepcionServiciosLaboratorio excepcionServiciosLaboratorio) {
            excepcionServiciosLaboratorio.printStackTrace();
        }
    }

    public List<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public List<Equipo> getListaEquiposFiltrada() {
        return listaEquiposFiltrada;
    }

    public void setListaEquiposFiltrada(List<Equipo> listaEquiposFiltrada) {
        this.listaEquiposFiltrada = listaEquiposFiltrada;
    }

    /**
     * Convierte el valor booleano de estado en un String que sea Activo o Inactivo para mostrar
     * en el frontend
     * @param estado estado del equipo
     * @return "Activo" "Inactivo"
     */
    public String convertToString(boolean estado){
        if (estado){
            return "Activo";
        }
        else {
            return "Inactivo";
        }
    }

    public List<Equipo> getEquiposSeleccionados() {
        return equiposSeleccionados;
    }

    public void setEquiposSeleccionados(List<Equipo> equiposSeleccionados) {
        this.equiposSeleccionados = equiposSeleccionados;
    }

    public Equipo getEquipoSeleccionado() {
        return equipoSeleccionado;
    }

    public void setEquipoSeleccionado(Equipo equipoSeleccionado) {
        this.equipoSeleccionado = equipoSeleccionado;
    }

    public void darDeBaja() {
        for (Equipo equipo : equiposSeleccionados) {
            equipo.darDeBaja();
        }
    }
}
