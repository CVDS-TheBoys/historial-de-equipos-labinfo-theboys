import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.samples.services.ServiciosElemento;
import edu.eci.cvds.samples.services.ServiciosElementoFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

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
    public void deberiaActualizarEquipo() {
        try {
            Equipo equipo = new Equipo(1, true, "Equipo 1");
            Elemento elemento1 = new Elemento(2, "LG", "Torre", true);
            serviciosElemento.registrarElemento(elemento1);
            serviciosElemento.actualizarEquipo(elemento1.getId(), equipo.getId());
            //System.out.println(serviciosElemento.consultarElementos());
            Assert.assertEquals(elemento1.getEquipo_id(), null);
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deberiaConsultarTipoElementoDisponibles() {
        try {
            //serviciosElemento.registrarElemento(elemento);
            Elemento elemento2 = new Elemento(3, "Samsung", "Pantalla", true);
            serviciosElemento.registrarElemento(elemento2);
            Assert.assertEquals(serviciosElemento.consultarTipoElementoDisponibles("Pantalla").size(), 1);
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

}
