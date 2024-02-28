import dao.BDOdontologo;
import dao.implementacion.OdontologoDAOH2;
import model.Odontologo;
import service.OdontologoService;

public class main {
    public static void main(String[] args) {
        BDOdontologo.createTable();

        Odontologo odontologo = new Odontologo("Martinez", "Carlos", "H12h");
        Odontologo odontologo1 = new Odontologo("Rodriguez", "Milton", "N34N");

        OdontologoService odontologoService = new OdontologoService(new OdontologoDAOH2());

        odontologoService.guardar(odontologo);
        odontologoService.guardar(odontologo1);

        System.out.println("Primer odontologo: " + odontologo + " Segundo odontologo: " + odontologo1);

        odontologoService.buscarTodos();
    }
}
