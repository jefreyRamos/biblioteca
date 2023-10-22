package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;

public record Biblioteca(Collection<Libro> libros) {

    public Biblioteca(){
        this(new LinkedList<>());
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
}
