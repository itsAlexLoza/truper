package dto;

import jakarta.validation.constraints.NotBlank;

public record DatosUserDto(
    @NotBlank(message = "Nombre es obligatorio")
    String nombre, 
    @NotBlank(message = "Password es obligatorio")
    String password
) {

}
