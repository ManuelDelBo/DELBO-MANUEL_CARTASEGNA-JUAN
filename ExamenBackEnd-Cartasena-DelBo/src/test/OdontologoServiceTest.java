package test;

import dao.implementacion.OdontologoDAOH2;
import model.Odontologo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDAOH2());

    @BeforeAll
    static void doBefore() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:./202402", "sa", "sa");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test
    void deberiaGuardarUnOdontologo() {
        Odontologo odontologo = new Odontologo("Martinez", "Juana", "1234");
        Odontologo odontologoRegistrado = odontologoService.guardar(odontologo);
        assertNotNull(odontologoRegistrado.getId());
        assertTrue(odontologoRegistrado.getId() != 0);
    }
}