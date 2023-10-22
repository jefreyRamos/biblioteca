package co.edu.uniquindio.poo;

public class LibroDigital extends Libro {
    private final String url;

    public LibroDigital(String nombre, Autor autor, Editorial editorial, int año, TipoLibro tipoLibro,
            boolean tieneVersionCD, String url) {
        super(nombre, autor, editorial, año, tipoLibro, tieneVersionCD);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
