package francescodicecca.TravelManagement.payloads;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record BookingDTO(
        @NotNull(message = "La data di richiesta è obbligatoria")
        LocalDate requestDate,

        String notes,

        @NotNull(message = "L'id è obbligatorio")
        Long employeeId,
        @NotNull(message = "L'id è obbligatorio")
        Long tripId) {
}
