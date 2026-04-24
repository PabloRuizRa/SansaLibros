package cl.usm.sansalibros.controllers;

import cl.usm.sansalibros.entities.Libro;
import cl.usm.sansalibros.services.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LibrosController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/libros")
    public ResponseEntity<List<Libro>> getAll(@RequestParam(name = "search", required = false) String search){
        try {
            if (search != null && !search.isEmpty()) {
                List<Libro> filtrados = this.libroService.filter(search);
                return ResponseEntity.ok(filtrados);
            }
            List<Libro> libros = this.libroService.getAll();
            return ResponseEntity.ok(libros);
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }

    }

    @PostMapping("/crearLibro")
    public ResponseEntity<Libro> createLibro(@RequestBody @Valid Libro libro){

        Libro creado = this.libroService.createLibro(libro);
        if (creado != null){
            return ResponseEntity.ok(creado);
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/libros/{autor}")
    public ResponseEntity<List<Libro>> getByAutor(@PathVariable String autor){

        try {
            List<Libro> libro = this.libroService.findByAutor(autor);
            if (libro.isEmpty()){
                return ResponseEntity.notFound().build();
            }


            return ResponseEntity.ok(libro);
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

}
