package cl.usm.sansalibros.entities;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "libros")
public class Libro implements Serializable {

    @NotBlank(message = "Debe tener Titulo")
    private String titulo;

    @NotBlank(message = "Debe tener Autor")
    private String autor;

    @Id
    @NotBlank(message = "Debe tener ISBN")
    @Size(min = 13, max = 13, message = "El ISBN debe tener 13 caracteres")
    private String isbn;

    @Min(value = 11, message = "Debe tener más de 10 páginas")
    private int paginas;

    @NotBlank(message = "Debe pertenecer a una Categoría")
    private String categoria;


}
