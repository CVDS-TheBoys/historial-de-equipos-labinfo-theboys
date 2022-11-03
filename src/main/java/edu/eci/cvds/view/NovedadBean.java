package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Novedad;
import edu.eci.cvds.samples.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.samples.services.ServiciosNovedad;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.sql.Date;
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

    public void sleep() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }

}