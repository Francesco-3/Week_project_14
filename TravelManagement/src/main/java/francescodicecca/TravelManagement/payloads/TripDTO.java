package francescodicecca.TravelManagement.payloads;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record TripDTO(
        @NotEmpty(message = "La destinazione è obbligatoria!")
        String destination,
        @NotNull(message = "La data è obbligatoria!")
        LocalDate date) {
}
