package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 *clase para realizar pruebas a la Biblioteca
*/
public class BibliotecaTest {
public static final Logger LOG = Logger.getLogger(AppTest.class.getName());
private Object biblioteca;

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
        LOG.info("iniciando test agregar libro repetido");

        var autor = new Autor("Autor1", "Nacionalidad1", 15);
        var editorial = new Editorial("Editorial1", "123-456-789");
        var libroImpreso1 = new LibroImpreso("LibroImpreso", autor, editorial, 2023, TipoLibro.IMPRESO, 15);
        var libroImpreso2 = new LibroImpreso("LibroImpreso", autor, editorial, 2023, TipoLibro.IMPRESO, 15);
        biblioteca.agregarLibro(libroImpreso1);

        assertThrows(Throwable.class, ()-> biblioteca.agregarLibro( libroImpreso2));

        LOG.info("Finalizando test agregar libro repetido");

    }
    
}
