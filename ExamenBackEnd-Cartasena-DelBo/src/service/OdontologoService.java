package service;

import dao.IDao;
import dao.implementacion.OdontologoDAOH2;
import model.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(OdontologoDAOH2 odontologoDAOH2) {
        this.odontologoIDao = new OdontologoDAOH2();;
    }

    public Odontologo guardar(Odontologo odontologo) {
        return odontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> buscarTodos(){
        return odontologoIDao.buscarTodos();
    }
}
