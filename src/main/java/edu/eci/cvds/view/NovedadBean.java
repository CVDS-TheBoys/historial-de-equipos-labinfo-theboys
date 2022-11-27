package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.services.ServiciosElemento;
import edu.eci.cvds.services.ServiciosEquipo;
import edu.eci.cvds.services.ServiciosNovedad;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Bean para la interfaz de usuario de las novedades
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "NovedadBean")
@SessionScoped
public class NovedadBean extends BasePageBean {
    @Inject
    private ServiciosNovedad serviciosNovedad;
    @Inject
    private ServiciosEquipo serviciosEquipo;
    @Inject
    private ServiciosElemento serviciosElemento;
    private Integer elementoId;
    private Integer equipoId;


    public void registrarNovedad(int id, String titulo, String detalle, int EQUIPO_id, int ELEMENTO_id) {
        Date fecha = new Date(System.currentTimeMillis());
        Novedad novedad = new Novedad(id, titulo, detalle, fecha, EQUIPO_id, ELEMENTO_id);
        try {
            serviciosNovedad.registrarNovedad(novedad);
        } catch (ExcepcionServiciosLaboratorio ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Novedad> getNovedades() {
        try {
            return serviciosNovedad.consultarNovedades();
        } catch (ExcepcionServiciosLaboratorio ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Novedad> getNovedadesEspecificas(Integer elementoId, Integer equipoId) {
        try {
            if (elementoId == 0) {
                return serviciosNovedad.consultarNovedadesEquipo(equipoId);
            } else {
                return serviciosNovedad.consultarNovedadesElemento(elementoId);
            }
        } catch (ExcepcionServiciosLaboratorio e) {
            e.printStackTrace();
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public String getElementName() {
        try {
            if (elementoId == null || elementoId == 0) {
                return "Equipo " + serviciosEquipo.consultarEquipo(equipoId).getNombre();

            } else {
                return "Elemento " + serviciosElemento.consultarElemento(elementoId).getNombre();
            }
        } catch (ExcepcionServiciosLaboratorio e) {
            e.printStackTrace();
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public void sleep() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }

    public Integer getElementoId() {
        return elementoId;
    }

    public void setElementoId(Integer elementoId) {
        this.elementoId = elementoId;
    }

    public Integer getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(Integer equipoId) {
        this.equipoId = equipoId;
    }

    public void serElementoIdEquipoId(Integer elementoId, Integer equipoId) {
        this.elementoId = elementoId;
        this.equipoId = equipoId;
    }
}