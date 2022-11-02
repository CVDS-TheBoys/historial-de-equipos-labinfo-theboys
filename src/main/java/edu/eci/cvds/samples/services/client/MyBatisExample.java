package edu.eci.cvds.samples.services.client;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ElementoMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.EquipoMapper;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.services.*;
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
     * @param args
     * @throws SQLException 
     */
    public static void main(String[] args) throws SQLException {

        SqlSessionFactory sessionfact = getSqlSessionFactory();
        SqlSession sqlss = sessionfact.openSession();

        //Creacion del mapper
        EquipoMapper mapper = sqlss.getMapper(EquipoMapper.class);
        Equipo eq1 = new Equipo(1, true, 1, "PC1");
        Equipo eq2 = new Equipo(2, false, 1, "PC2");
        Equipo eq3 = new Equipo(3, true, 2, "PC3");
        Equipo eq4 = new Equipo(4, false, 3, "PC4");
        Equipo eq5 = new Equipo(5, true, 4, "PC5");
        Equipo eq6 = new Equipo(6, false, 5, "PC6");
        Equipo eq7 = new Equipo(7, true, 6, "PC7");
        Equipo eq8 = new Equipo(8, false, 7, "PC8");
        Equipo eq9 = new Equipo(9, true, 8, "PC9");
        Equipo eq10 = new Equipo(10, false, 9, "PC10");
        Equipo eq11 = new Equipo(11, true, 10, "PC11");
        System.out.println("Laboratorio_id eq1 "+eq1.getLaboratorio_id());
        System.out.println("Laboratorio_id eq6 "+eq6.getLaboratorio_id());
        System.out.println("Laboratorio_id eq9 "+eq9.getLaboratorio_id());
        mapper.insertarEquipo(eq1);
        mapper.insertarEquipo(eq2);
        mapper.insertarEquipo(eq3);
        mapper.insertarEquipo(eq4);
        mapper.insertarEquipo(eq5);
        mapper.insertarEquipo(eq6);
        mapper.insertarEquipo(eq7);
        mapper.insertarEquipo(eq8);
        mapper.insertarEquipo(eq9);
        mapper.insertarEquipo(eq10);
        mapper.insertarEquipo(eq11);
        System.out.println("Consultar Reporte");
        System.out.println(mapper.consultarReporte());
        System.out.println("=====================================");
        //System.out.println(mapper.consultarReporteFiltro(1, null, null, null));





        //Crear el mapper y probarlo
        //Elemento
        //ElementoMapper em = sqlss.getMapper(ElementoMapper.class);
        //Elemento elemento = new Elemento(1, "pupito", "Teclado", true);
        //em.insertarElemento(elemento);
        //System.out.println(em.consultarElementos());

        //Equipo
        //EquipoMapper eqm = sqlss.getMapper(EquipoMapper.class);
        //Equipo equipo = new Equipo(1, true, "equipo1");
        //eqm.insertarEquipo(equipo);
        //System.out.println(eqm.consultarEquipos());

        sqlss.commit();
        sqlss.close();


        // Prueba servicio
        /*
<<<<<<< Updated upstream
        ServiciosElemento serviciosElemento = ServiciosElementoFactory.getInstance().getServiciosElemento();
        try {
            // Elemento
            System.out.println(serviciosElemento.consultarElementos());
            serviciosElemento.registrarElemento(elemento);
            System.out.println(serviciosElemento.consultarElementos());

        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
=======
        //ServiciosLaboratorio serviciosLaboratorio = ServiciosLaboratorioFactory.getInstance().getServiciosLaboratorio();
        //try {
            // Elemento
            //serviciosLaboratorio.registrarElemento(elemento);
        //   System.out.println(serviciosLaboratorio.consultarElementos());

            // Equipo
            //serviciosLaboratorio.registrarEquipo(equipo);
        //    System.out.println(serviciosLaboratorio.consultarEquipos());
        //} catch (ExcepcionServiciosLaboratorio e) {
        //    throw new RuntimeException(e);
        //}
>>>>>>> Stashed changes
    */
    }

}
