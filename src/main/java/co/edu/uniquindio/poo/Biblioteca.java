package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public record Biblioteca(String nombre, Collection<Libro> libros) {

    public Biblioteca(String nombre){
        this(nombre, new LinkedList<>());
    }

    public void agregarLibro(Libro libro){
        validarLibroRepetido(libro);
        libros.add(libro);
    }

    private void validarLibroRepetido(Libro libro) {
        boolean existeLibro = buscarLibro(libro).isPresent();
        assert !existeLibro : "ya existe un libro con el mismo nombre";
    }

    public Optional<Libro> buscarLibro(Libro libro){
        Predicate<Libro> nombreIgual = j->j.getNombre().equals(libro.getNombre());
        return libros.stream().filter(nombreIgual).findAny();
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


}
