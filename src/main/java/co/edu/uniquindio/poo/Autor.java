package co.edu.uniquindio.poo;

public class Autor {
    private String nombre;
    private String nacionalidad;
    private int añoNacimiento;

    public Autor(String nombre, String nacionalidad, int añoNacimiento) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.añoNacimiento = añoNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public int getAñoNacimiento() {
        return añoNacimiento;
    }
}
