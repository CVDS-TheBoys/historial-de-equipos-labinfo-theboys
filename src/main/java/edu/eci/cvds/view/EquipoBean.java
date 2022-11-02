package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.samples.services.ServiciosEquipo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Bean para la interfaz de usuario de los equipos
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "EquiposBean")
@SessionScoped
public class EquipoBean extends BasePageBean{
    @Inject
    private ServiciosEquipo serviciosEquipo;

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

}
