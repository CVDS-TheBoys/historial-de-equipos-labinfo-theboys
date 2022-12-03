package edu.eci.cvds.services.client;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;

import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.persistence.mybatis.mappers.ElementoMapper;
import edu.eci.cvds.persistence.mybatis.mappers.EquipoMapper;
import edu.eci.cvds.persistence.mybatis.mappers.NovedadMapper;
import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.services.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config-h2.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     *
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();
        SqlSession sqlss = sessionfact.openSession();

        // Crear el mapper y probarlo
        // Elemento
        ElementoMapper em = sqlss.getMapper(ElementoMapper.class);
        Elemento elemento = new Elemento(1, "pupito", "Teclado", true);
        // em.insertarElemento(elemento);
        // System.out.println(em.consultarElementos());

        // Equipo
        EquipoMapper eqm = sqlss.getMapper(EquipoMapper.class);
        Equipo equipo = new Equipo(2, true, "equipo1");
        // eqm.insertarEquipo(equipo);
        // System.out.println(eqm.consultarEquipos());

        // em.actualizarEquipo(1, 2);
        // System.out.println(em.consultarElementos());

        // Novedad
        NovedadMapper nvd = sqlss.getMapper(NovedadMapper.class);
        Date fecha = new Date(System.currentTimeMillis());
        Novedad novedad = new Novedad(1, "novedad1", "detalle1", fecha, 1, 1);
        // nvd.insertarNovedad(novedad);
        // System.out.println(nvd.consultarNovedades());
        sqlss.commit();
        sqlss.close();

        // Laboratorio
        Date fecha_creacion = new Date(System.currentTimeMillis());
        Date fecha_cierre = Date.valueOf("2022-10-11");
        Laboratorio laboratorio = new Laboratorio(3, "Lab1", 0, true, fecha_creacion);

        // Prueba servicio
        ServiciosElemento serviciosElemento = ServiciosElementoFactory.getInstance().getServiciosElemento();
        ServiciosNovedad serviciosNovedad = ServiciosNovedadFactory.getInstance().getServiciosNovedad();
        ServiciosEquipo serviciosEquipo = ServiciosEquipoFactory.getInstance().getServiciosEquipo();
        ServiciosLaboratorio serviciosLaboratorio = ServiciosLaboratorioFactory.getInstance().getServiciosLaboratorio();
        ServiciosUsuario serviciosUsuario = ServiciosUsuarioFactory.getInstance().getServiciosUsuario();

        try {
            // Elemento
            // System.out.println(serviciosElemento.consultarElementos());
            // serviciosElemento.registrarElemento(elemento);
            // System.out.println(serviciosElemento.consultarElementos().size());
            // System.out.println(serviciosElemento.consultarElementosConNovedades().size());
            // System.out.println(serviciosElemento.consultarElemento(1));
            // System.out.println(serviciosElemento.consultarElementosConNovedades(1));
            // serviciosElemento.actualizarEquipo(1, null);
            // serviciosElemento.darBajaElemento(4);
            // System.out.println(serviciosElemento.consultarElementosDisponibles());

            // Novedades
            // System.out.println(serviciosNovedad.consultarNovedad(333));
            // serviciosNovedad.registrarNovedad(novedad);
            // System.out.println(serviciosNovedad.consultarNovedadesElemento(1));
            // System.out.println(serviciosNovedad.consultarNovedadesEquipo(1));

            // Equipo
            // serviciosEquipo.registrarEquipo(equipo);
            // System.out.println(serviciosEquipo.consultarEquipos());

            // Laboratorio
            // serviciosLaboratorio.registrarLaboratorio(laboratorio);
            // System.out.println(serviciosLaboratorio.consultarLaboratorios());

            // Usuario
            System.out.println(serviciosUsuario.consultarUsuario("prueba", "prueba"));

        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }

    }

}
