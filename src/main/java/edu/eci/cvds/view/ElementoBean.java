package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.services.ServiciosElemento;

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

    private List<Elemento> listaElementos;

    private List<Elemento> elementosSeleccionados;

    private List<Elemento> listaElementosFiltrada;


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

    public List<Elemento> getElementosConNovedades(Integer equipoId) {
        try {
            if (equipoId == null || equipoId == 0) {
                return serviciosElemento.consultarElementosConNovedades();
            } else {
                return serviciosElemento.consultarElementosConNovedades(equipoId);
            }

        } catch (ExcepcionServiciosLaboratorio ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String getEquipoAsociado(Integer equipo_id) {
        return serviciosElemento.getEquipoAsociado(equipo_id);
    }

    public void sleep() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }

    public List<Elemento> getListaElementos() {
        return listaElementos;
    }

    public void setListaElementos(List<Elemento> listaElementos) {
        this.listaElementos = listaElementos;
    }

    public List<Elemento> getElementosSeleccionados() {
        return elementosSeleccionados;
    }

    public void setElementosSeleccionados(List<Elemento> elementosSeleccionados) {
        this.elementosSeleccionados = elementosSeleccionados;
    }

    public List<Elemento> getListaElementosFiltrada() {
        return listaElementosFiltrada;
    }

    public void setListaElementosFiltrada(List<Elemento> listaElementosFiltrada) {
        this.listaElementosFiltrada = listaElementosFiltrada;
    }

    /**
     * Convierte el valor booleano de estado en un String que sea Activo o Inactivo para mostrar
     * en el frontend
     * @param funcional estado del equipo
     * @return "Activo" "Inactivo"
     */
    public String convertToString(boolean funcional){
        if (funcional){
            return "Activo";
        }
        else {
            return "Dado de baja";
        }
    }
}
