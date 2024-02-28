package dao.implementacion;

import dao.BDOdontologo;
import dao.IDao;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOH2.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {

        Connection connection = null;

        try {
            connection = BDOdontologo.getConnection();

            PreparedStatement psInsert = connection.prepareStatement("INSERT INTO ODONTOLOGO (MATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, odontologo.getMatricula());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());

            psInsert.execute();

            ResultSet resultSet = psInsert.getGeneratedKeys();
            while (resultSet.next()) {
                odontologo.setId(resultSet.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LOGGER.info("ID: " + odontologo.getId());
        return odontologo;
    }
    @Override
    public List<Odontologo> buscarTodos() {
        LOGGER.info("Consultamos todos los odontologos: ");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try {
            connection = BDOdontologo.getConnection();
            preparedStatement = connection.prepareStatement("SELECT *  FROM ODONTOLOGO");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Odontologo odontologo = new Odontologo();
                odontologo.setId(resultSet.getInt(1));
                odontologo.setNombre(resultSet.getString(2));
                odontologo.setApellido(resultSet.getString(3));
                odontologo.setMatricula(resultSet.getString(4));
                odontologos.add(odontologo);
            }

        } catch (Exception e) {
            LOGGER.error("ERROR: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LOGGER.info(odontologos);
        return odontologos;
    }
}
