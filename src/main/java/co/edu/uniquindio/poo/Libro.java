package co.edu.uniquindio.poo;

public class Libro {
    private final String nombre;
    private final Autor autor;
    private final Editorial editorial;
    private final int año;
    private final TipoLibro tipoLibro;

    public Libro(String nombre, Autor autor, Editorial editorial, int año, TipoLibro tipoLibro) {
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.año = año;
        this.tipoLibro = tipoLibro;

        assert nombre != null;
        assert año >= 0;
    }

    public String getNombre() {
        return nombre;
    }

    public Autor getAutor() {
        return autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public int getAño() {
        return año;
    }

    public TipoLibro getTipoLibro() {
        return tipoLibro;
    }

}
