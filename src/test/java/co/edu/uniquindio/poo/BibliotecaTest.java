package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    public void buscarLibroPorAutor() {
        LOG.info("inicio test buscar un libro por su autor");

        var autor1 = new Autor("Autor1", "Nacionalidad1", 2001);
        var autor2 = new Autor("Autor2", "Nacionalidad2", 2002);
        var editorial = new Editorial("Editorial1", "123-456-789");
        var biblioteca = new Biblioteca("marta");
        var libroImpreso1 = new LibroImpreso("LibroImpreso", autor1, editorial, 2023, TipoLibro.IMPRESO, 15);
        var libroImpreso2 = new LibroImpreso("LibroImpreso2", autor1, editorial, 2023, TipoLibro.IMPRESO, 15);
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

    @Test
    public void testBuscarLibroCDPorNombreYFormato() {
        LOG.info("inicio test buscar un libro cd por nombre y formato");

        var biblioteca = new Biblioteca("marta");
        var autor = new Autor("Autor1", "Nacionalidad1", 15);
        var editorial = new Editorial("Editorial1", "123-456-789");
        var libroCD1 = new LibroCD("Libro1", autor, editorial, 2023, TipoLibro.CD, false, 700, "MP3");
        var libroCD2 = new LibroCD("Libro2", autor, editorial, 2023, TipoLibro.CD, false, 700, "MP3");
        var libroCD3 = new LibroCD("Libro3", autor, editorial, 2023, TipoLibro.CD, false, 500, "MP4");
        var libroCD4 = new LibroCD("Libro4", autor, editorial, 2023, TipoLibro.CD, false, 702, "MP5");

        biblioteca.agregarLibro(libroCD1);
        biblioteca.agregarLibro(libroCD2);
        biblioteca.agregarLibro(libroCD3);
        biblioteca.agregarLibro(libroCD4);

        List<Libro> librosEncontrados = biblioteca.buscarLibroCDPorNombreYFormato("Libro1", "MP3");

        assertEquals(1, librosEncontrados.size());
        assertEquals("Libro1", librosEncontrados.get(0).getNombre());
        assertEquals("MP3", ((LibroCD) librosEncontrados.get(0)).getFormatoCD());

        LOG.info("Fin test buscar un libro cd por nombre y formato");
    }

    @Test
    public void testBuscarLibrosDigitalesConVersionImpresa() {
        LOG.info("Iniciando el test buscar un libros digital con version impresa");

        var biblioteca = new Biblioteca("marta");
        var autor = new Autor("Autor1", "Nacionalidad1", 15);
        var editorial = new Editorial("Editorial1", "123-456-789");
        var libroDigital = new LibroDigital("Libro1", autor, editorial, 2023, null, "URL_Digital");
        var libroImpreso = new LibroImpreso("Libro1", autor, editorial, 2023, TipoLibro.IMPRESO, 15);
        var libroDigital2 = new LibroDigital("Libro2", autor, editorial, 2023, null, "URL_Digital2");

        biblioteca.agregarLibro(libroDigital);
        biblioteca.agregarLibro(libroImpreso);
        biblioteca.agregarLibro(libroDigital2);

        var librosDigitalesConVersionImpresa = biblioteca.buscarLibrosDigitalesConVersionImpresa();
        assertEquals(1, librosDigitalesConVersionImpresa.size());

        LOG.info("Finalizando el test buscar un libros digital con version impresa");
    }

    @Test
    public void testContarTiposDeLibroPorNombre() {
        LOG.info("Iniciando el test buscar un libros y mostrar cuantos tipos tiene");

        var biblioteca = new Biblioteca("marta");
        var autor = new Autor("Autor1", "Nacionalidad1", 15);
        var editorial = new Editorial("Editorial1", "123-456-789");
        var libroImpreso = new LibroImpreso("Libro", autor, editorial, 2023, TipoLibro.IMPRESO, 15);
        var libroDigital = new LibroDigital("Libro", autor, editorial, 2023, null, "URL_Digital");
        var libroCD = new LibroCD("Libro", autor, editorial, 2023, null, false, 700, "MP3");

        biblioteca.agregarLibro(libroImpreso);
        biblioteca.agregarLibro(libroDigital);
        biblioteca.agregarLibro(libroCD);

        var cantidadTipos = biblioteca.contarTiposDeLibroPorNombre("Libro");
        assertEquals(3, cantidadTipos);

        LOG.info("Finalizando el test buscar un libros y mostrar cuantos tipos tiene");
    }
}