package com.example.demo;

public class LibroMapper {

    public static LibroDTO toDTO(Libro libro) {

        return new LibroDTO(
                libro.getId(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getPaginas()
        );

    }

    public static Libro toEntity(LibroDTO dto) {

        Libro libro = new Libro();
        libro.setTitulo(dto.titulo());
        libro.setAutor(dto.autor());
        libro.setPaginas(dto.paginas());

        return libro;

    }

}