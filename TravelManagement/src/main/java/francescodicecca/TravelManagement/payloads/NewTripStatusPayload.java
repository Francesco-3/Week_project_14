package francescodicecca.TravelManagement.payloads;

import francescodicecca.TravelManagement.entities.enums.TripStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class NewTripStatusPayload {
    @NotNull(message = "Lo stato è obbligatorio")
    private TripStatus status;
}
