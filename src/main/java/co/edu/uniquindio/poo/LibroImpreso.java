package co.edu.uniquindio.poo;

public class LibroImpreso extends Libro {
    private final int cantidadEjemplares;

    public LibroImpreso(String nombre, Autor autor, Editorial editorial, int año, TipoLibro tipoLibro,
            int cantidadEjemplares) {
        super(nombre, autor, editorial, año, tipoLibro);
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public int getCantidadEjemplares() {
        return cantidadEjemplares;
    }

}
