import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.samples.services.ServiciosEquipo;
import edu.eci.cvds.samples.services.ServiciosEquipoFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

public class ServiciosEquipoTest {
    @Inject
    private SqlSession sqlSession;
    private ServiciosEquipo serviciosEquipo;
    private Equipo equipo = new Equipo(1, true, 1, "PC1");

    public ServiciosEquipoTest() {
        serviciosEquipo = ServiciosEquipoFactory.getInstance().getServiciosEquipoTesting();
    }

    @Test
    public void deberiaInsertarElemento() {
        try {
            serviciosEquipo.registrarEquipo(equipo);
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deberiaConsultarElementos() {
        try {
            serviciosEquipo.registrarEquipo(equipo);
            Assert.assertEquals(serviciosEquipo.consultarEquipos().get(0).getNombre(), "PC1");
            Assert.assertEquals(serviciosEquipo.consultarEquipos().get(0).getId(), 1);
            Assert.assertEquals(serviciosEquipo.consultarEquipos().get(0).isEstado(), true);
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test() {
        try {
            System.out.println(serviciosEquipo.consultarEquipos());
        } catch (ExcepcionServiciosLaboratorio excepcionServiciosLaboratorio) {
            excepcionServiciosLaboratorio.printStackTrace();
        }
        Assert.assertTrue(true);
    }

}
