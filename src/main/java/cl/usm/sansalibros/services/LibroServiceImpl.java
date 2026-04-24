package cl.usm.sansalibros.services;


import cl.usm.sansalibros.entities.Libro;
import cl.usm.sansalibros.repositories.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService{

    @Autowired
    LibrosRepository librosRepository;

    @Override
    public Libro createLibro(Libro libro) {
        return librosRepository.insert(libro);
    }

    @Override
    public List<Libro> getAll() {
        return this.librosRepository.findAll();
    }

    @Override
    public List<Libro> filter(String query) {
        return this.librosRepository.findByTituloOrAutor(query);
    }

    @Override
    public List<Libro> findByAutor(String autor) {
        return librosRepository.findByAutor(autor);
    }
}
