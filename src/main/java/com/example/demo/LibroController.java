package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class LibroController {
    private final LibroService libroService;  // dependencia

    // constructor    
    public LibroController (LibroService libroService){
            this.libroService = libroService;
    }

        @GetMapping("/buscar") //GET TODOS
        public ResponseEntity<List<LibroDTO>> buscarLibros() {
            return ResponseEntity.ok(libroService.buscarTodos());
        }

        @GetMapping("/libros/{id}")//GET POR ID
        public ResponseEntity<LibroDTO> buscarLibroPorId(@PathVariable Long id){
            return ResponseEntity.ok(libroService.buscarLibroPorId(id));
        }

        @GetMapping("/libros")//GET POR AUTOR
        public ResponseEntity<List<LibroDTO>> buscarLibrosPorAutor(@RequestParam String autor){
            return ResponseEntity.ok(libroService.buscarLibrosPorAutor(autor));

        }

        @PostMapping("/libros") //POST
        public ResponseEntity<LibroDTO> crearLibro(@Valid @RequestBody LibroDTO libroDTO) {
            LibroDTO libroCreado = libroService.crearLibro(libroDTO);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(libroCreado);
        }

        @PutMapping ("/libros/{id}")//PUT
        public ResponseEntity<LibroDTO> modificarLibro(@PathVariable Long id, @Valid @RequestBody LibroDTO informacion){
            LibroDTO libroActualizado = libroService.cambiarLibro(id, informacion);
            return ResponseEntity.ok(libroActualizado);
        }

        @DeleteMapping ("/libros/{id}") //DELETE
        public ResponseEntity<String> eliminarLibroPorId(@PathVariable Long id){
            return ResponseEntity.ok(libroService.eliminarLibroPorId(id));
        }


}       
