package dto;

import java.sql.Date;
import java.util.List;

public record CrearOrden(
        String nombreSucursal,
        Date fecha,
        Double total,
        List<ProductoDto> productos
) {
}
