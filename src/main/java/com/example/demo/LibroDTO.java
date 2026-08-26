package com.example.demo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


public record LibroDTO(
        Long id,

        @NotBlank(message = "El titulo es obligatorio")
        String titulo,

        @NotBlank(message = "El autor es obligatorio")
        String autor,

        @Positive(message = "Las paginas deben ser mayores a cero")
        int paginas

) {
}
