package dto;

import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CrearOrden(
        @NotBlank(message = "Nombre de la sucursal es obligatorio")
        String nombreSucursal,
        @DateTimeFormat(style = "YYYY-MM-DD")
        Date fecha,
        @NotNull
        @Positive
        Double total,
        @NotEmpty
        List<ProductoDto> productos
) {
}
