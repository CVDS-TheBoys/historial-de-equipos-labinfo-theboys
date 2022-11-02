import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.samples.services.ServiciosElemento;
import edu.eci.cvds.samples.services.ServiciosElementoFactory;
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
    public void test() {
        Assert.assertTrue(true);
    }
}
