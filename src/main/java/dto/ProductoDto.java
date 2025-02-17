package dto;

public record ProductoDto(
        Long producto_id,
        String codigo,
        String descripcion,
        Double precio
) {
}
