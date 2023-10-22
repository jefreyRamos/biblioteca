package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
/**
 *clase para realizar pruebas a la Biblioteca
*/
public class BibliotecaTest {
public static final Logger LOG = Logger.getLogger(AppTest.class.getName());

      //  Libro libroImpreso = new LibroImpreso("LibroImpreso", autor, editorial, 2023, TipoLibro.IMPRESO, 15);
      //  Libro libroDigital = new LibroDigital("LibroDigital", autor, editorial, 2023, TipoLibro.DIGITAL, "URL_Digital");
      //  Libro libroCD = new LibroCD("LibroCD", autor, editorial, 2023, TipoLibro.CD, 700, "MP3");
      //  biblioteca.agregarLibro(libroImpreso);
      //  biblioteca.agregarLibro(libroDigital);
      //  biblioteca.agregarLibro(libroCD);

    /**
     * 
     */
    @Test
    public void agregarLibroRepetido() {
        LOG.info("inicio test agregar libro repetido");

        Autor autor = new Autor("Autor1", "Nacionalidad1", 15);
        Editorial editorial = new Editorial("Editorial1", "123-456-789");
        var biblioteca = new Biblioteca("marta");
        var libroImpreso1 = new LibroImpreso("LibroImpreso", autor, editorial, 2023, TipoLibro.IMPRESO, false, 15);
        var libroImpreso2 = new LibroImpreso("LibroImpreso", autor, editorial, 2023, TipoLibro.IMPRESO, false, 15);

        biblioteca.agregarLibro(libroImpreso1);
        assertThrows(Throwable.class, ()-> biblioteca.agregarLibro( libroImpreso2));

        LOG.info("Fin test agregar libro repetido");

    }

    @Test
    public void buscarLibroPorAutor() {
        LOG.info("inicio test buscar un libro por su autor");

        var autor1 = new Autor("Autor1", "Nacionalidad1", 2001);
        var autor2 = new Autor("Autor2", "Nacionalidad2", 2002);
        var editorial = new Editorial("Editorial1", "123-456-789");
        var biblioteca = new Biblioteca("marta");
        var libroImpreso1 = new LibroImpreso("LibroImpreso", autor1, editorial, 2023, TipoLibro.IMPRESO, false, 15);
        var libroImpreso2 = new LibroImpreso("LibroImpreso2", autor1, editorial, 2023, TipoLibro.IMPRESO, false, 15);
        var libroCD = new LibroCD("LibroCD", autor2, editorial, 2023, TipoLibro.CD, false, 700, "MP3");

        biblioteca.agregarLibro(libroImpreso1);
        biblioteca.agregarLibro(libroImpreso2);
        biblioteca.agregarLibro(libroCD);
        List<Libro> librosAutor1 = biblioteca.buscarLibrosPorAutor("Autor1");
        List<Libro> librosAutor2 = biblioteca.buscarLibrosPorAutor("Autor2");

        assertEquals(2, librosAutor1.size()); // Autor1 escribió 2 libros
        assertEquals(1, librosAutor2.size());
        LOG.info("Fin test buscar un libro por su autor");

    }
    
}
