package francescodicecca.TravelManagement.payloads;

import francescodicecca.TravelManagement.entities.enums.TripStatus;
import jakarta.validation.constraints.*;

public record TripStatusDTO(
        @NotNull(message = "Lo stato è obblogatorio")
        TripStatus status) {
}
