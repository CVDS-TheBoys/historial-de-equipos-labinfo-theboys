import com.google.inject.Inject;
import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.services.*;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;

public class ServiciosEquipoTest {
    @Inject
    private SqlSession sqlSession;
    private final ServiciosElemento serviciosElemento;
    private final ServiciosEquipo serviciosEquipo;
    private ServiciosLaboratorio serviciosLaboratorio;
    private final Equipo equipo = new Equipo(1, true, "Equipo 1");

    public ServiciosEquipoTest() {
        serviciosEquipo = ServiciosEquipoFactory.getInstance().getServiciosEquipoTesting();
        serviciosElemento = ServiciosElementoFactory.getInstance().getServiciosElementoTesting();
    }

    @Test
    public void deberiaInsertarEquipo() {
        try {
            serviciosEquipo.registrarEquipo(equipo);
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deberiaConsultarEquipos() {
        try {
            serviciosEquipo.registrarEquipo(equipo);
            Assert.assertEquals(serviciosEquipo.consultarEquipos().get(0).getNombre(), "Equipo 1");
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deberiaConsultarTipoElemento() {
        try {
            Equipo equipo1 = new Equipo(1, true, "Equipo 1");
            Elemento elemento = new Elemento(55, "Logitech", "Teclado", true);
            serviciosEquipo.registrarEquipo(equipo1);
            serviciosElemento.registrarElemento(elemento);
            serviciosElemento.actualizarEquipo(elemento.getId(), equipo1.getId());
            Assert.assertEquals(serviciosEquipo.consultarElementoTipo(equipo1.getId(), "Teclado").getNombre(), "Logitech");
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deberiaActualizarLab() {
        try {
            serviciosEquipo.registrarEquipo(equipo);
            Laboratorio laboratorio = new Laboratorio(1, "Prueba", 10, true, new Date(System.currentTimeMillis()));
            //serviciosLaboratorio.registrarLaboratorio(laboratorio);
            serviciosEquipo.actualizarLaboratorio(equipo.getId(), laboratorio.getId());
            Integer num = 1;
            Assert.assertEquals(num, serviciosEquipo.consultarEquipo(equipo.getId()).getLaboratorio_id());
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deberiaEliminarAsociacion() {
        try {
            serviciosEquipo.registrarEquipo(equipo);
            Laboratorio laboratorio = new Laboratorio(1, "Prueba", 10, true, new Date(System.currentTimeMillis()));
            serviciosEquipo.actualizarLaboratorio(equipo.getId(), laboratorio.getId());
            serviciosEquipo.eliminarAsociacion(equipo.getId());
            Assert.assertNull(serviciosEquipo.consultarEquipo(equipo.getId()).getLaboratorio_id());
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deberiaConsultarEquiposEnLab() {
        try {
            Laboratorio laboratorio = new Laboratorio(2, "Prueba", 10, true, new Date(System.currentTimeMillis()));
            Equipo equipo2 = new Equipo(2, true, "Equipo 2");
            serviciosEquipo.registrarEquipo(equipo);
            serviciosEquipo.registrarEquipo(equipo2);
            serviciosEquipo.actualizarLaboratorio(equipo.getId(), laboratorio.getId());
            serviciosEquipo.actualizarLaboratorio(equipo2.getId(), laboratorio.getId());
            Assert.assertEquals(2, serviciosEquipo.consultarEquiposEnLaboratorio(laboratorio.getId()).size());
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

}
