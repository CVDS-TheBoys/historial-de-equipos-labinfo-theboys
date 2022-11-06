package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.samples.services.ServiciosElemento;
import edu.eci.cvds.samples.services.ServiciosEquipo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
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
    @Inject
    private ServiciosElemento serviciosElemento;

    /**
     * Registra un equipo junto con sus elementos
     * @param equipoId del equipo
     * @param nombre del equipo
     * @param pantallaId que pertenece al equipo
     * @param torreId que pertenece al equipo
     * @param tecladoId que pertenece al equipo
     * @param mouseId que pertenece al equipo
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
     * Muestra el nombre del equipo asociado al elemento en la pantalla
     * @param id id del equipo
     * @return el nombre del equipo asociado en caso de tener, "No aplica" de lo contrario
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

    public List<Equipo> getEquiposConNovedades() {
        try {
            return serviciosEquipo.consultarEquiposConNovedades();
        } catch (ExcepcionServiciosLaboratorio ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
