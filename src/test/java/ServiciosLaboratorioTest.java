import com.google.inject.Inject;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.services.ServiciosLaboratorio;
import edu.eci.cvds.services.ServiciosLaboratorioFactory;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

public class ServiciosLaboratorioTest {
    @Inject
    private ServiciosLaboratorio serviciosLabServiciosLaboratorio;
    private Date fecha = new Date(System.currentTimeMillis());
    private Laboratorio laboratorio = new Laboratorio(1001, "LaboratorioTest", 2, true, fecha);

    public ServiciosLaboratorioTest() {
        serviciosLabServiciosLaboratorio = ServiciosLaboratorioFactory.getInstance().getServiciosLaboratorioTesting();
    }

    @Test
    public void deberiaInsertarLaboratorio() {
        try {
            serviciosLabServiciosLaboratorio.registrarLaboratorio(laboratorio);
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deberiaConsultarLaboratorioes() {
        try {
            serviciosLabServiciosLaboratorio.registrarLaboratorio(laboratorio);
            Assert.assertEquals(serviciosLabServiciosLaboratorio.consultarLaboratorios().get(0).getNombre(),
                    "LaboratorioTest");
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deberiaConsultarLaboratorio() {
        try {
            serviciosLabServiciosLaboratorio.registrarLaboratorio(laboratorio);
            Assert.assertEquals(serviciosLabServiciosLaboratorio.consultarLaboratorio(1001).getNombre(),
                    "LaboratorioTest");
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deberiaConsultarLaboratoriosDisponibles() {
        try {
            Laboratorio laboratorio2 = new Laboratorio(1002, "Laboratorio", 2, false, fecha);
            serviciosLabServiciosLaboratorio.registrarLaboratorio(laboratorio2);
            List<Laboratorio> labs = serviciosLabServiciosLaboratorio.consultarLaboratorios();
            List<Laboratorio> labsDisponibles = serviciosLabServiciosLaboratorio.consultarLaboratoriosDisponibles();
            Assert.assertEquals(labs.size() - 1, labsDisponibles.size());
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }


}
