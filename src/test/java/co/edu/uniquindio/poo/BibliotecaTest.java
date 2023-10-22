package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 *clase para realizar pruebas a la Biblioteca
*/
public class LibreriaTest {

    public static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    @Test
    public void testContarTiposLibrosPorNombre() {
        LOG.info("inicio test contar tipos de libros por el nombre");
        Biblioteca biblioteca = new Biblioteca();

        Autor autor = new Autor("Autor1", "Nacionalidad1", 15);
        Editorial editorial = new Editorial("Editorial1", "123-456-789");

        Libro libroImpreso = new LibroImpreso("LibroImpreso", autor, editorial, 2023, TipoLibro.IMPRESO, 15);
        
        Libro libroImpreso2 = new LibroImpreso("LibroImpreso", autor, editorial, 2023, TipoLibro.IMPRESO, 15);
        Libro libroDigital = new LibroDigital("LibroDigital", autor, editorial, 2023, TipoLibro.DIGITAL, "URL_Digital");
        Libro libroCD = new LibroCD("LibroCD", autor, editorial, 2023, TipoLibro.CD, 700, "MP3");

        biblioteca.agregarLibro(libroImpreso);
        biblioteca.agregarLibro(libroDigital);
        biblioteca.agregarLibro(libroCD);

        assertEquals(1, biblioteca.contarTiposLibrosPorNombre("LibroImpreso"));
        assertEquals(1, biblioteca.contarTiposLibrosPorNombre("LibroDigital"));
        assertEquals(1, biblioteca.contarTiposLibrosPorNombre("LibroCD"));
        assertEquals(0, biblioteca.contarTiposLibrosPorNombre("LibroInexistente"));

        LOG.info("fin test contar tipos de libros por nombre");
    }
    
}
