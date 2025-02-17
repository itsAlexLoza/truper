package dto;

import java.util.List;

public record BadResponseDto(
    String mensaje,
    List<String> detalles
) {

}
