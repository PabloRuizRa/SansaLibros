package cl.usm.sansalibros.services;

import cl.usm.sansalibros.entities.Libro;

import java.util.List;

public interface LibroService {
    Libro createLibro(Libro libro);
    List<Libro> getAll();
    List<Libro> filter(String query);
    List<Libro> findByAutor(String autor);

}
