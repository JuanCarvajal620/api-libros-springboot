package com.example.demo;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;



@Service
public class LibroService {


   private final LibroRepository repository;

   public LibroService(LibroRepository repository){
       this.repository = repository;
   }


    public List<LibroDTO> buscarTodos() {
        List<Libro> libros = repository.findAll();
        List<LibroDTO> resultados = new ArrayList<>();

        for (Libro libro : libros) {
            resultados.add(LibroMapper.toDTO(libro));
        }
        return resultados;
    }



   public LibroDTO buscarLibroPorId(Long id) {
        Libro libro = repository.findById(id)
                .orElseThrow(() -> new LibroNoEncontradoException("Libro No Encontrado"));

            return LibroMapper.toDTO(libro);
   }


    public LibroDTO crearLibro(LibroDTO libroDTO) {

        Libro libro = LibroMapper.toEntity(libroDTO);
        repository.save(libro);
        return LibroMapper.toDTO(libro);
    }



    public List<LibroDTO> buscarLibrosPorAutor(
        String autor){

        List<Libro> libros =
                repository.findByAutorIgnoreCase(autor);
            if(libros.isEmpty()){
                throw new LibroNoEncontradoException("Libro No Encontrado");
        }

        List<LibroDTO> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            resultados.add(LibroMapper.toDTO(libro));
        }
            return resultados;
    }


    public String eliminarLibroPorId(Long id){
        Libro libro = repository.findById(id)
                .orElseThrow(() -> new LibroNoEncontradoException("Libro no encontrado"));
        repository.delete(libro);

        return "Libro con id " + id + " eliminado";
    }


    public LibroDTO cambiarLibro(Long id, LibroDTO informacion) {
        Libro libro = repository.findById(id)
                        .orElseThrow(() -> new LibroNoEncontradoException("Libro no encontrado"));

        libro.setTitulo(informacion.titulo());
        libro.setAutor(informacion.autor());
        libro.setPaginas(informacion.paginas());

        repository.save(libro);

        return LibroMapper.toDTO(libro);
    }

}   
