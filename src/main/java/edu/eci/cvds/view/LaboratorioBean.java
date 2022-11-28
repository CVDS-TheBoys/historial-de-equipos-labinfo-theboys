package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.services.ServiciosEquipo;
import edu.eci.cvds.services.ServiciosLaboratorio;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("deprecation")
@ManagedBean(name = "LaboratorioBean")
@SessionScoped
public class LaboratorioBean extends BasePageBean {
    @Inject
    private ServiciosLaboratorio serviciosLaboratorio;
    @Inject
    private ServiciosEquipo serviciosEquipo;

    private List<Laboratorio> listaLaboratorio;

    private List<Laboratorio> listaLaboratoriosFiltrada;

    public void registrarLaboratorio(int id, String nombre, Integer cantidad_equipos) {
        if (cantidad_equipos == null) {
            cantidad_equipos = 0;
        }
        Date fecha_creacion = new Date(System.currentTimeMillis());
        Laboratorio laboratorio = new Laboratorio(id, nombre, cantidad_equipos, true, fecha_creacion);
        try {
            serviciosLaboratorio.registrarLaboratorio(laboratorio);
        } catch (ExcepcionServiciosLaboratorio ex) {
            ex.printStackTrace();
        }
    }

    public List<Laboratorio> getLaboratorios() {
        try {
            return serviciosLaboratorio.consultarLaboratorios();
        } catch (ExcepcionServiciosLaboratorio ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Laboratorio> getLaboratoriosDisponibles() {
        try {
            List<Laboratorio> laboratorios = serviciosLaboratorio.consultarLaboratorios();
            List<Laboratorio> laboratoriosFilt = new ArrayList<Laboratorio>();
            for (Laboratorio lab : laboratorios) {
                if (lab.isEstado()) {
                    laboratoriosFilt.add(lab);
                }
            }
            return laboratoriosFilt;
        } catch (ExcepcionServiciosLaboratorio ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Laboratorio getLaboratorio(int id) {
        try {
            return serviciosLaboratorio.consultarLaboratorio(id);
        } catch (ExcepcionServiciosLaboratorio ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void sleep() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }

    public String convertToString(boolean estado) {
        if (estado) {
            return "Activo";
        } else {
            return "Cerrado";
        }
    }

    public String getFechaCierre(Integer id) {
        String res = "";
        Date fecha_cierre = null;
        try {
            fecha_cierre = serviciosLaboratorio.consultarLaboratorio(id).getFecha_cierre();
            if (fecha_cierre != null) {
                res = res + fecha_cierre;
            } else {
                res = res + "No aplica";
            }
            return res;
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

    public void cerrarLaboratorio(int id) throws ExcepcionServiciosLaboratorio {
        serviciosLaboratorio.cerrarLaboratorio(id);
        List<Equipo> equipos = serviciosEquipo.consultarEquiposLaboratorio(id);
        for (Equipo equipo : equipos) {
            serviciosEquipo.darBajaEquipo(equipo.getId());
        }
    }

}
