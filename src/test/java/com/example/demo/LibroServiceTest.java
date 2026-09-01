package com.example.demo;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;



public class LibroServiceTest {

    @Mock
    private LibroRepository repository;
    private LibroService libroService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        libroService = new LibroService(repository);
    }

    @Test
    void debeBuscarLibroPorId() {

        Libro libro = new Libro();
        libro.setId(1L);
        libro.setTitulo("Harry Potter");
        libro.setAutor("J.K. Rowling");
        libro.setPaginas(500);

        when(repository.findById(1L))
                .thenReturn(Optional.of(libro));

        LibroDTO resultado =
                libroService.buscarLibroPorId(1L);

        assertEquals("Harry Potter",
                resultado.titulo());
    }

    @Test
    void debeLanzarExcepcionCuandoLibroNoExiste() {

        when(repository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(
                LibroNoEncontradoException.class,
                () -> libroService.buscarLibroPorId(1L)
        );
    }

}