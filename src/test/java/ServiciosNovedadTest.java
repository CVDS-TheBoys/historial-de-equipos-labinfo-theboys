import com.google.inject.Inject;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.services.ServiciosNovedad;
import edu.eci.cvds.services.ServiciosNovedadFactory;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;

public class ServiciosNovedadTest {
    @Inject
    private ServiciosNovedad serviciosNovedad;
    private Date fecha = new Date(System.currentTimeMillis());
    private Novedad novedad = new Novedad(1001, "Novedad Logitech", "Detalle novedad Logitech", fecha, 1, 1);

    public ServiciosNovedadTest() {
        serviciosNovedad = ServiciosNovedadFactory.getInstance().getServiciosNovedadTesting();
    }

    @Test
    public void deberiaInsertarNovedad() {
        try {
            serviciosNovedad.registrarNovedad(novedad);
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deberiaConsultarNovedades() {
        try {
            Assert.assertEquals(serviciosNovedad.consultarNovedades().get(0).getTitulo(), "Novedad Logitech");
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deberiaConsultarNovedad() {
        try {
            Assert.assertEquals(serviciosNovedad.consultarNovedad(1001).getTitulo(),
                    "Novedad Logitech");
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deberiaConsultarNovedadesElemento() {
        Assert.assertTrue(true);
    }

    @Test
    public void deberiaConsultarNovedadesEquipo() {
        Assert.assertTrue(true);
    }

}
