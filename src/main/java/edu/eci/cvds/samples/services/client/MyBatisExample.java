package edu.eci.cvds.samples.services.client;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ElementoMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.EquipoMapper;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.services.*;
import edu.eci.cvds.samples.services.impl.ServiciosEquipoImpl;
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

        //Crear el mapper y probarlo
        //Elemento
        ElementoMapper em = sqlss.getMapper(ElementoMapper.class);
        Elemento elemento = new Elemento(1, "pupito", "Teclado", true);

        em.insertarElemento(elemento);
        System.out.println(em.consultarElementos());

        //Equipo
        EquipoMapper eqm = sqlss.getMapper(EquipoMapper.class);
        Equipo equipo = new Equipo(2, true, "equipo1");
        eqm.insertarEquipo(equipo);
        System.out.println(eqm.consultarEquipos());

        em.actualizarEquipo(1, 2);
        System.out.println(em.consultarElementos());

        sqlss.commit();
        sqlss.close();


        // Prueba servicio
        ServiciosElemento serviciosElemento = ServiciosElementoFactory.getInstance().getServiciosElemento();
        /*ServiciosEquipo serviciosEquipo = ServiciosEquipoFactory.getInstance().getServiciosEquipo();
        try {
            // Elemento
            System.out.println(serviciosElemento.consultarElementos());
            serviciosElemento.registrarElemento(elemento);
            System.out.println(serviciosElemento.consultarElementos());

            // Equipo
            serviciosEquipo.registrarEquipo(equipo);
            System.out.println(serviciosEquipo.consultarEquipos());

        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }*/

    }


}
