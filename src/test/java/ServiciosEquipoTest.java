import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.services.*;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class ServiciosEquipoTest {
    @Inject
    private SqlSession sqlSession;
    private ServiciosElemento serviciosElemento;
    private final ServiciosEquipo serviciosEquipo;
    private final Equipo equipo = new Equipo(1, true, "Equipo 1");

    public ServiciosEquipoTest() {
        serviciosEquipo = ServiciosEquipoFactory.getInstance().getServiciosEquipoTesting();
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

}
