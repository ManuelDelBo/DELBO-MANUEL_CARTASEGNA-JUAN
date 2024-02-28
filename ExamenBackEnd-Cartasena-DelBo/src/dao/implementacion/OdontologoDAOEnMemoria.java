package dao.implementacion;

import dao.BDOdontologo;
import dao.IDao;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOEnMemoria implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOEnMemoria.class);
    private List<Odontologo> odontologoRepository;

    public void OdontologoDaoEnMemoria(List<Odontologo> odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        int id = odontologoRepository.size()+1;
        odontologoRepository.add(odontologo);
        Odontologo odontologoGuardado = new Odontologo(
                id,
                odontologo.getMatricula(),
                odontologo.getNombre(),
                odontologo.getApellido());
        LOGGER.info("Se ha registrado el odontologo: " + odontologoGuardado);
        return odontologo;
    }
    @Override
    public List<Odontologo> buscarTodos() {
        LOGGER.info("Estamos consultando todos los domicilios");
        Connection connection = null;
        List<Odontologo> odontologoList = new ArrayList<>();
        Odontologo odontologo = null;

        try {
            connection = BDOdontologo.getConnection();
            PreparedStatement psSelect = connection.prepareStatement("SELECT *  FROM ODONTOLOGO");
            ResultSet rs = psSelect.executeQuery();

            while (rs.next()) {
                odontologo = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                odontologoList.add(odontologo);
            }
        } catch (Exception e) {
            LOGGER.error("ERROR: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LOGGER.info("Devuelve: " + odontologoList);
        return odontologoList;
    }
}
