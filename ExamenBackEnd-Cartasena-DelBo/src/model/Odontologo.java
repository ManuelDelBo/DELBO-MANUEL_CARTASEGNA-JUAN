package model;

public class Odontologo {

    private Integer Id;
    private String apellido;
    private String nombre;
    private String matricula;

    public Odontologo(String apellido, String nombre, String matricula) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public Odontologo() {
    }

    public Odontologo(int anInt, String string, String string1, String string2) {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apelido) {
        this.apellido = apelido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Id = " + Id +
                ", Sr./Sra. " + apellido + " " +
                nombre +
                ", matricula= " + matricula + " / ";
    }
}
