package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.services.ServiciosElemento;
import edu.eci.cvds.services.ServiciosEquipo;
import edu.eci.cvds.services.ServiciosNovedad;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.sql.Date;
import java.util.List;

/**
 * Bean para la interfaz de usuario de los equipos
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "EquiposBean")
@SessionScoped
public class EquipoBean extends BasePageBean {
    @Inject
    private ServiciosEquipo serviciosEquipo;

    @Inject
    private ServiciosElemento serviciosElemento;

    @Inject
    private ServiciosNovedad serviciosNovedad;

    private List<Equipo> listaEquipos;
    private List<Equipo> listaEquiposFiltrada;
    private List<Equipo> equiposSeleccionados;

    /**
     * Registra un equipo junto con sus elementos
     * 
     * @param equipoId   del equipo
     * @param nombre     del equipo
     * @param pantallaId que pertenece al equipo
     * @param torreId    que pertenece al equipo
     * @param tecladoId  que pertenece al equipo
     * @param mouseId    que pertenece al equipo
     */
    public void registrarEquipo(int equipoId, String nombre, int pantallaId, int torreId, int tecladoId, int mouseId) {
        Equipo equipo = new Equipo(equipoId, true, nombre);
        try {
            serviciosEquipo.registrarEquipo(equipo);
            serviciosElemento.actualizarEquipo(pantallaId, equipoId);
            serviciosElemento.actualizarEquipo(torreId, equipoId);
            serviciosElemento.actualizarEquipo(tecladoId, equipoId);
            serviciosElemento.actualizarEquipo(mouseId, equipoId);
        } catch (ExcepcionServiciosLaboratorio ex) {
            ex.printStackTrace();
        }
    }

    /**
     * <<<<<<< HEAD
     * Muestra el nombre del equipo asociado al elemento en la pantalla
     * 
     * @param id id del equipo
     * @return el nombre del equipo asociado en caso de tener, "No aplica" de lo
     *         contrario
     */
    public String displayEquipos(int id) {
        try {
            Equipo equipo = serviciosEquipo.consultarEquipo(id);
            return equipo != null ? equipo.getNombre() : "No aplica";
        } catch (ExcepcionServiciosLaboratorio ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Consulta todos los equipos
     */
    public List<Equipo> consultarEquipos() {
        try {
            return serviciosEquipo.consultarEquipos();
        } catch (ExcepcionServiciosLaboratorio excepcionServiciosLaboratorio) {
            excepcionServiciosLaboratorio.printStackTrace();
            return null;
        }
    }

    public List<Equipo> getEquiposConNovedades() {
        try {
            return serviciosEquipo.consultarEquiposConNovedades();
        } catch (ExcepcionServiciosLaboratorio ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Consulta el reporte de los equipos activos
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
     * Convierte el valor booleano de estado en un String que sea Activo o Inactivo
     * para mostrar
     * en el frontend
     * 
     * @param estado estado del equipo
     * @return "Activo" "Inactivo"
     */
    public String convertToString(boolean estado) {
        if (estado) {
            return "Activo";
        } else {
            return "Inactivo";
        }
    }

    public List<Equipo> getEquiposSeleccionados() {
        return equiposSeleccionados;
    }

    public void setEquiposSeleccionados(List<Equipo> equiposSeleccionados) {
        this.equiposSeleccionados = equiposSeleccionados;
    }

    public void darBajaEquipo() {
        Date date = new Date(System.currentTimeMillis());
        try {
            if (equiposSeleccionados != null) {
                for (Equipo equipo : equiposSeleccionados) {
                    serviciosEquipo.darBajaEquipo(equipo.getId());
                    Novedad novedad = new Novedad(1000, "Equipo " + equipo.getNombre() + " dado de baja", "", date,
                            equipo.getId());
                    serviciosNovedad.registrarNovedad(novedad);
                }
            }
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }
}
