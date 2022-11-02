package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.samples.services.ServiciosElemento;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import java.util.ArrayList;
import java.util.List;

/**
 * Bean para la interfaz de usuario de los elementos
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "ElementosBean")
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

}
