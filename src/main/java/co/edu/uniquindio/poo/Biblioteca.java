package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public record Biblioteca(String nombre, Collection<Libro> libros) {

    public Biblioteca(String nombre){
        this(nombre, new LinkedList<>());
    }

    public void agregarLibro(Libro libro){
        libros.add(libro);
    }

    public Collection<Libro> getLibros() {
        return libros;
    }

    public List<Libro> buscarLibrosPorAutor(String nombreAutor) {
        return libros.stream()
                .filter(libro -> libro.getAutor().getNombre().equals(nombreAutor))
                .collect(Collectors.toList());
    }

    public List<Libro> buscarLibroCDPorNombreYFormato(String nombre, String formato) {
        return libros.stream()
                .filter(libro -> libro instanceof LibroCD) // Filtrar solo libros en formato CD
                .filter(libro -> libro.getNombre().equals(nombre) && ((LibroCD) libro).getFormatoCD().equals(formato))
                .collect(Collectors.toList());
    }

    public List<Libro> buscarLibrosDigitalesConVersionImpresa() {
        return libros.stream()
                .filter(libro -> libro instanceof LibroDigital) // Filtrar libros digitales
                .filter(libroDigital ->
                        libros.stream()
                                .anyMatch(libroImpreso -> libroImpreso instanceof LibroImpreso &&
                                        libroImpreso.getNombre().equals(libroDigital.getNombre())))
                .collect(Collectors.toList());
    }

    public int contarTiposDeLibroPorNombre(String nombreLibro) {
        return (int) libros.stream()
                .filter(libro -> libro.getNombre().equals(nombreLibro))
                .count();
    }
}
