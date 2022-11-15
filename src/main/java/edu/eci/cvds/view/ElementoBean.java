package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.services.ServiciosElemento;
import edu.eci.cvds.services.ServiciosEquipo;
import edu.eci.cvds.services.ServiciosNovedad;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.Date;
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
    @Inject
    private ServiciosEquipo serviciosEquipo;
    @Inject
    private ServiciosNovedad serviciosNovedad;
    static final String DEL_TITLE = "Cambio asociación";
    static final String DEL_DETAIL = "Se eliminó asociación con ";
    static final String NEW_TITLE = "Nueva asociación";
    static final String NEW_DETAIL = "Se asoció el elemento al equipo";




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

    public void asociarElementos(int equipoId, Integer pantallaId, Integer torreId, Integer tecladoId, Integer mouseId) {
        try {
            asociarPantalla(equipoId, pantallaId);
            asociarTorre(equipoId, torreId);
            asociarTeclado(equipoId, tecladoId);
            asociarMouse(equipoId, mouseId);
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }

    }

    public void asociarPantalla(int equipoId, Integer pantallaId) throws ExcepcionServiciosLaboratorio {
            Elemento pantalla = serviciosEquipo.consultarElementoTipo(equipoId, "Pantalla");
            Date date = new Date(System.currentTimeMillis());
            if (pantalla != null && pantallaId != 0) {
                serviciosElemento.actualizarEquipo(pantalla.getId(), null);
                serviciosNovedad.registrarNovedad(new Novedad(66, DEL_TITLE, DEL_DETAIL+serviciosEquipo.consultarEquipo(equipoId).getNombre(), date, pantalla.getId()));
            } if (pantallaId != 0) {
                serviciosElemento.actualizarEquipo(pantallaId, equipoId);
                serviciosNovedad.registrarNovedad(new Novedad(66, NEW_TITLE, NEW_DETAIL, date, equipoId, pantallaId));
            }

    }

    public void asociarTorre(int equipoId, Integer torreId) throws ExcepcionServiciosLaboratorio {
            Elemento torre = serviciosEquipo.consultarElementoTipo(equipoId, "Torre");
            Date date = new Date(System.currentTimeMillis());
            if (torre != null && torreId != 0) {
                serviciosElemento.actualizarEquipo(torre.getId(), null);
                serviciosNovedad.registrarNovedad(new Novedad(66, DEL_TITLE, DEL_DETAIL+serviciosEquipo.consultarEquipo(equipoId).getNombre(), date, torre.getId()));
            } if (torreId != 0) {
                serviciosElemento.actualizarEquipo(torreId, equipoId);
                serviciosNovedad.registrarNovedad(new Novedad(66, NEW_TITLE, NEW_DETAIL, date, equipoId, torreId));
            }
    }

    public void asociarTeclado(int equipoId, Integer tecladoId) throws ExcepcionServiciosLaboratorio {
            Elemento teclado = serviciosEquipo.consultarElementoTipo(equipoId, "Teclado");
            Date date = new Date(System.currentTimeMillis());
            if (teclado != null && tecladoId != 0) {
                serviciosElemento.actualizarEquipo(teclado.getId(), null);
                serviciosNovedad.registrarNovedad(new Novedad(66, DEL_TITLE, DEL_DETAIL+serviciosEquipo.consultarEquipo(equipoId).getNombre(), date, teclado.getId()));
            } if (tecladoId != 0) {
                serviciosElemento.actualizarEquipo(tecladoId, equipoId);
                serviciosNovedad.registrarNovedad(new Novedad(66, NEW_TITLE, NEW_DETAIL, date, equipoId, tecladoId));
            }
    }

    public void asociarMouse(int equipoId, Integer mouseId) throws ExcepcionServiciosLaboratorio {
            Elemento mouse = serviciosEquipo.consultarElementoTipo(equipoId, "Mouse");
            Date date = new Date(System.currentTimeMillis());
            if (mouse != null && mouseId != 0) {
                serviciosElemento.actualizarEquipo(mouse.getId(), null);
                serviciosNovedad.registrarNovedad(new Novedad(66, DEL_TITLE, DEL_DETAIL+serviciosEquipo.consultarEquipo(equipoId).getNombre(), date, mouseId));
            } if (mouseId != 0) {
                serviciosElemento.actualizarEquipo(mouseId, equipoId);
                serviciosNovedad.registrarNovedad(new Novedad(66, NEW_TITLE, NEW_DETAIL, date, equipoId, mouseId));
            }
    }

    public void sleep() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }

}
