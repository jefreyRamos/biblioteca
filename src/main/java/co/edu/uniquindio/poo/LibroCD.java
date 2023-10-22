package co.edu.uniquindio.poo;

public class LibroCD extends Libro {
    private final int tamañoMbCD;
    private final String formatoCD;

    public LibroCD(String nombre, Autor autor, Editorial editorial, int año, TipoLibro tipoLibro,
            boolean tieneVersionCD, int tamañoMbCD, String formatoCD) {
        super(nombre, autor, editorial, año, tipoLibro, tieneVersionCD);
        this.tamañoMbCD = tamañoMbCD;
        this.formatoCD = formatoCD;
    }

    public int getTamañoMbCD() {
        return tamañoMbCD;
    }

    public String getFormatoCD() {
        return formatoCD;
    }
}
