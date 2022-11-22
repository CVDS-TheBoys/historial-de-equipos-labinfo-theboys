import com.google.inject.Inject;
import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.services.*;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

public class ServiciosEquipoTest {
    @Inject
    private SqlSession sqlSession;
    private ServiciosElemento serviciosElemento;
    private final ServiciosEquipo serviciosEquipo;
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

}
