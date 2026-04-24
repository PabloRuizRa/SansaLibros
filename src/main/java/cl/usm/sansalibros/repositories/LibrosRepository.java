package cl.usm.sansalibros.repositories;

import cl.usm.sansalibros.entities.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface LibrosRepository extends MongoRepository<Libro, String> {

    List<Libro> findByAutor(String autor);

    @Query("{ '$or': [ { 'titulo': { '$regex': ?0, '$options': 'i' } }, { 'autor': { '$regex': ?0, '$options': 'i' } } ] }")
    List<Libro> findByTituloOrAutor(String search);
}
