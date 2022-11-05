package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.samples.services.ServiciosElemento;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Bean para la interfaz de usuario de los elementos
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "ElementoBean")
@SessionScoped
public class ElementoBean extends BasePageBean {
    @Inject
    private ServiciosElemento serviciosElemento;


    public void registrarElemento(int id, String nombre, String tipo) {
        Elemento elemento = new Elemento(id, nombre, tipo, true);
        try {
            serviciosElemento.registrarElemento(elemento);
        } catch (ExcepcionServiciosLaboratorio ex) {
            ex.printStackTrace();
        }
    }

    public List<Elemento> getElementos() {
        try {
            return serviciosElemento.consultarElementos();
        } catch (ExcepcionServiciosLaboratorio ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public List<Elemento> getTipoElementosDisponibles(String tipo) {
        try {
            return serviciosElemento.consultarTipoElementoDisponibles(tipo);
        } catch (ExcepcionServiciosLaboratorio ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Elemento getElemento(int id) {
        try {
            return serviciosElemento.consultarElemento(id);
        } catch (ExcepcionServiciosLaboratorio ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Elemento> getElementosConNovedades() {
        try {
            return serviciosElemento.consultarElementosConNovedades();
        } catch (ExcepcionServiciosLaboratorio ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public void sleep() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }

}
