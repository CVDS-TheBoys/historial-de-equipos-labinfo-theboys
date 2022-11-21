package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.services.ServiciosLaboratorio;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.Date;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


@SuppressWarnings("deprecation")
@ManagedBean(name = "LaboratorioBean")
@SessionScoped
public class LaboratorioBean extends BasePageBean{
    @Inject
    private ServiciosLaboratorio serviciosLaboratorio;

    public void registrarLaboratorio(int id, String nombre, Integer cantidad_equipos) {
        if(cantidad_equipos==null){
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

    public ArrayList<Laboratorio> getLaboratorios() {
        try {
            return serviciosLaboratorio.consultarLaboratorios();
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
}
