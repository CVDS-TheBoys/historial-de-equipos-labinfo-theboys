import com.google.inject.Inject;
import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.services.ServiciosElemento;
import edu.eci.cvds.services.ServiciosElementoFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

public class ServiciosElementoTest {
    @Inject
    private SqlSession sqlSession;
    private ServiciosElemento serviciosElemento;
    private Elemento elemento = new Elemento(1, "Logitech", "Teclado", true);;

    public ServiciosElementoTest() {
        serviciosElemento = ServiciosElementoFactory.getInstance().getServiciosElementoTesting();
    }

    @Test
    public void deberiaInsertarElemento() {
        try {
            serviciosElemento.registrarElemento(elemento);
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deberiaConsultarElementos() {
        try {
            serviciosElemento.registrarElemento(elemento);
            Assert.assertEquals(serviciosElemento.consultarElementos().get(0).getNombre(), "Logitech");
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deberiaConsultarElemento() {
        try {
            serviciosElemento.registrarElemento(elemento);
            Assert.assertEquals(serviciosElemento.consultarElemento(1).getNombre(), "Logitech");
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deberiaActualizarEquipo() {
        try {
            Equipo equipo = new Equipo(1, true, "Equipo 1");
            Elemento elemento1 = new Elemento(2, "LG", "Torre", true);
            serviciosElemento.registrarElemento(elemento1);
            serviciosElemento.actualizarEquipo(elemento1.getId(), equipo.getId());
            Integer numero = 1;
            Assert.assertEquals(serviciosElemento.consultarElemento(2).getEquipo_id(), numero);
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deberiaConsultarTipoElementoDisponibles() {
        try {
            Elemento elemento2 = new Elemento(3, "Samsung", "Pantalla", true);
            serviciosElemento.registrarElemento(elemento2);
            Assert.assertEquals(serviciosElemento.consultarTipoElementoDisponibles("Pantalla").size(), 1);
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deberiaDarBajaElemento() {
        try {
            Elemento elemento4 = new Elemento(4, "Samsung4", "Pantalla", true);
            serviciosElemento.registrarElemento(elemento4);
            serviciosElemento.darBajaElemento(4);
            Assert.assertFalse(serviciosElemento.consultarElemento(4).isFuncional());
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

}
